class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] grid = new char[n][n];
        for(char[] row : grid) {
            Arrays.fill(row, '.');
        }

        boolean[] rdiag = new boolean[2*n-1];
        boolean[] ndiag = new boolean[2*n-1];
        boolean[] cols = new boolean[n];

        nQueens(grid, 0, n, answer, rdiag, ndiag, cols);
        return answer;
    }

    private void nQueens(char[][] grid, int r, int n, List<List<String>> answer, boolean[] rdiag, boolean[] ndiag, boolean[] cols) {
        // base case
        if(r == n) {
            List<String> temp = new ArrayList<>();
            for(char[] row : grid) {
                temp.add(String.valueOf(row));
            }
            answer.add(temp);
            return;
        }
        // main logic
        for(int c = 0; c < n; c++) {
            boolean isCurrentCellSafe = isSafe(grid, r, c, n, rdiag, ndiag, cols);
            if(isCurrentCellSafe) {
                grid[r][c] = 'Q';
                ndiag[r - c + n - 1] = true;
                rdiag[r + c] = true;
                cols[c] = true;

                nQueens(grid, r + 1, n, answer, rdiag, ndiag, cols);

                grid[r][c] = '.';
                ndiag[r - c + n - 1] = false;
                rdiag[r + c] = false;
                cols[c] = false;
            }
        }
    }

    private boolean isSafe(char[][] grid, int r, int c, int n, boolean[] rdiag, boolean[] ndiag, boolean[] cols) {
        return grid[r][c] == '.' && 
                !ndiag[r - c + n - 1] && 
                    !rdiag[r + c] && 
                        !cols[c];
    }
}