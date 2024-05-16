class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        boolean[]ndiag = new boolean[2*n-1];
        boolean[]rdiag = new boolean[2*n-1];
        boolean[]cols = new boolean[n];
        
        char[][] board = new char[n][n];
        for(char[] row : board)
            Arrays.fill(row, '.');
        
        nQueens(board, ndiag, rdiag, cols, 0, n, answer);
        return answer;
    }
    private void nQueens(char[][] board, boolean[] ndiag, boolean[] rdiag, boolean[] cols, int row, int n, List<List<String>> answer) {
        // base case
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder t = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    t.append(board[i][j]);
                }
                temp.add(t.toString());
            }
            answer.add(temp);
            return;
        }
        
        // main logic
        for(int col = 0; col < n; col++) {
            if(isSafe(board, ndiag, rdiag, cols, n, row, col)) {
                board[row][col] = 'Q';
                ndiag[row + col] = true;
                rdiag[row - col + n - 1] = true;
                cols[col] = true;
                
                nQueens(board, ndiag, rdiag, cols, row + 1, n, answer);
                
                board[row][col] = '.';
                ndiag[row + col] = false;
                rdiag[row - col + n - 1] = false;
                cols[col] = false;
            }
        }
    }
    
    private boolean isSafe(char[][] board, boolean[] ndiag, boolean[] rdiag, boolean[] cols, int n, int row, int col) {
        if(col < n && board[row][col] == '.' && 
          !ndiag[row + col] && !rdiag[row - col + n - 1] && !cols[col])
            return true;
        return false;
    }
}