
/*
    curr cell  -> count of neigh 1    -> change to     -> constant space solution
     1             < 2                      0                   3
     1             2 | 3                    1                   2
     1              > 3                     0                   3
     0               3                      1                   4
*/

class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        
        int[]dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[]dy = {0, 0, -1, 1, -1, 1, 1, -1};
        
        for(int i = 0 ; i < n ; i++ ) {
            for(int j = 0; j < m ; j++) {
                int cnt = getCount(board, i, j, n, m, dx, dy);
                
                if(board[i][j] == 0 && cnt == 3) board[i][j] = 4;
                else if(board[i][j] == 1) {
                    if(cnt < 2) board[i][j] = 3;
                    else if(cnt == 2 || cnt == 3) board[i][j] = 2;
                    else if(cnt > 3) board[i][j] = 3;
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++ ) {
            for(int j = 0; j < m ; j++) {
                if(board[i][j] == 3)
                    board[i][j] = 0;
                else if(board[i][j] == 2 || board[i][j] == 4)
                    board[i][j] = 1;
            }
        }
        
    }
    
    private int getCount(int[][]board, int i, int j, int n, int m, int[]dx, int []dy) {
        int cnt = 0;
        for(int k = 0; k < 8; k++) {
            int newX = dx[k] + i;
            int newY = dy[k] + j;
            if(newX >= 0 && newX < n && newY >= 0 && newY < m) {
                if(board[newX][newY] == 2 || 
                   board[newX][newY] == 3 || 
                   board[newX][newY] == 1)
                    cnt++;
            }
        }
        return cnt;
    }
}