class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        
        char[][] board = new char[n][n];
        for(char[] row : board)
            Arrays.fill(row, '.');
        
        
        boolean[] rdiag = new boolean[2*n-1];
        boolean[] ndiag = new boolean[2*n-1];
        boolean[] cols = new boolean[n];
        
        nQueens(board, 0, rdiag, ndiag, cols, n, answer);
        return answer;
    }
    
    private void nQueens(char[][] board, int row, boolean[] rdiag, boolean[] ndiag, boolean[] cols, int n, List<List<String>> answer) {
        if(row == n) {
            List<String> t = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    temp.append(board[i][j]);
                }
                t.add(temp.toString());
            }
            answer.add(t);
            return;
        }
        
        for(int c = 0; c < n; c++) {
            boolean isCurrentCellSafe = isSafe(board, row, c, rdiag, ndiag, cols, n);
            
            if(isCurrentCellSafe) {
                rdiag[row - c + n - 1] = true;
                ndiag[row + c] = true;
                cols[c] = true;
                board[row][c] = 'Q';
                
                nQueens(board, row + 1, rdiag, ndiag, cols, n, answer);
                
                board[row][c] = '.';
                rdiag[row - c + n - 1] = false;
                ndiag[row + c] = false;
                cols[c] = false;
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col, boolean[] rdiag, boolean[] ndiag, boolean[] cols, int n) {
        if( cols[col] == false &&
            ndiag[row+col] == false &&
            rdiag[row-col+n-1] == false) {
            return true;
        }
        return false;
    }
}