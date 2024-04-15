class Solution {
    private static final char CONST = '_';
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((i == 0 || i == n-1 || j == 0 || j == m-1) && 
                    board[i][j] == 'O') {
                    dfs(board, i, j, n, m);
                } 
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == CONST) {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j, int n, int m) {
        boolean isCurrentCellSafe = isSafe(board, i, j, n, m);
        if(isCurrentCellSafe) {
            board[i][j] = CONST;
            dfs(board, i-1, j, n, m);
            dfs(board, i+1, j, n, m);
            dfs(board, i, j-1, n, m);
            dfs(board, i, j+1, n, m);
        }
    }
    private boolean isSafe(char[][] board, int i, int j, int n, int m) {
        if(i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O')
            return true;
        return false;
    }
}