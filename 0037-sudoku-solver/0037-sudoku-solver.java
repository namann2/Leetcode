class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        sudoku(board, 0, 0, 9, 9);
    }
    
    private boolean sudoku(char[][] board, int rc, int cc, int row, int col) {
        // base case
        if(cc == col) {
            cc = 0;
            rc++;
        }
        
        if(rc == row)
            return true;
        
        // main logic
        if(board[rc][cc] != '.') {
            return sudoku(board, rc, cc + 1, row, col);
        } else {
            for(char c = '1'; c <= '9'; c++) {
                boolean isValid = isValidPlacement(board, rc, cc, c);
                if(isValid) {
                    board[rc][cc] = c;
                    if(sudoku(board, rc, cc + 1, row, col)) return true;
                    board[rc][cc] = '.';
                }
            }
        }
        return false;
    }
    private boolean isValidPlacement(char[][] board, int rc, int cc, int val) {
        for(int i = 0 ;i < 9; i++) {
            if(board[rc][i] == val) return false;
            if(board[i][cc] == val) return false;
        }
        
        int blockRow = rc / 3 * 3;
        int blockCol = cc / 3 * 3;
        
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                if(board[r + blockRow][c + blockCol] == val) return false;
            }
        }
        return true;
    }
}