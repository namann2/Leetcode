class Solution {
    public List<List<String>> solveNQueens(int n) {
        // simple base case
        if(n == 1) return List.of(List.of("Q"));
        // not possible for n = 2,3
        if(n < 4) return new ArrayList<>();
        // generate other possibilities
        List<List<String>> arrangements = new ArrayList<>();
        
        boolean[] columns = new boolean[n];
        boolean[] ndiag = new boolean[2*n - 1];
        boolean[] rdiag = new boolean[2*n - 1];
        char[][] arrangement = new char[n][n];

        for(char[] row : arrangement) {
            Arrays.fill(row, '.');
        }

        nQueens(0, n, columns, ndiag, rdiag, arrangement, arrangements);
        return arrangements;
    }

    private void nQueens(int row, int n, boolean[] columns, boolean[] ndiag, boolean[] rdiag, char[][] arrangement, List<List<String>> arrangements) {
        // base case
        if(row == n) {
            List<String> currArrangement = new ArrayList<>();
            for(char[] iRow : arrangement) {
                currArrangement.add(String.valueOf(iRow));
            }
            arrangements.add(currArrangement);
            return;
        }

        // main logic
        for(int col = 0; col < n; col++) {
            
            boolean isCurrentCellSafe = isSafe(row, col, columns, ndiag, rdiag, n);
            
            if(isCurrentCellSafe) {
                columns[col] = true;
                ndiag[row + col] = true;
                rdiag[row - col + n - 1] = true;

                arrangement[row][col] = 'Q';
                nQueens(row + 1, n, columns, ndiag, rdiag, arrangement, arrangements);
                arrangement[row][col] = '.';

                columns[col] = false;
                ndiag[row + col] = false;
                rdiag[row - col + n - 1] = false;
            }
        }
    }

    private boolean isSafe(int row, int col, boolean[] columns, boolean[] ndiag, boolean[] rdiag, int n) {
        return !columns[col] && !ndiag[row + col] && !rdiag[row - col + n - 1];
    }
}