class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        sudoku(board, 0, 0, 9, 9);
    }
    private boolean sudoku(char[][] board, int row, int col, int rl, int cl) {
        
        // base condition
        if(col == cl) {
            row += 1;
            col = 0;
        }
        
        if(row == rl) return true;
        
        // main logic
        if(board[row][col] != '.') {
            return sudoku(board, row, col+1, rl, cl);
        } else {
            for(char i='1';i<='9';i++) {
                boolean isValid = isValid(board, row, col, i);
                if(isValid) {
                    board[row][col] = i;
                    if(sudoku(board, row, col+1, rl, cl)) return true;
                    board[row][col] = '.';
                }
            }
            return false;
        }
    }
    private boolean isValid(char[][] board, int row, int col, char value) {
        // same row, same col
        for(int i=0;i<9;i++) {
            if(board[row][i] == value) return false;
            if(board[i][col] == value) return false;
        }
        
        // same 3*3 grid
        int blockRow = row / 3 * 3; // start row for this block
        int blockCol = col / 3 * 3; // start col for this block
        for(int r = 0;r < 3; r++) {
            for(int c = 0;c < 3; c++) {
                if(board[r + blockRow][c + blockCol] == value) return false;
            }
        }
        
        return true;
    }

}