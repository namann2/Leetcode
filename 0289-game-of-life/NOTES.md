for(int i=0;i<rows;i++) {
for(int j=0;j<cols;j++) {
int curr = board[i][j];
int neigh = countNeighbors(board, i, j);
if(curr == 1 && (neigh < 2 || neigh > 3)) board[i][j] = 2; // alive to dead
if(curr == 0 && neigh == 3) board[i][j] = 3; // dead to alive
}
}
for(int i=0;i<rows;i++) {
for(int j=0;j<cols;j++) {
if(board[i][j] > 1) {
board[i][j] -= 2;
}
}
}
}
private int countNeighbors(int[][] board, int row, int col) {
int count = 0, rowN = board.length, colN = board[0].length;
// up
if(row>0 && (board[row-1][col] == 1 || board[row-1][col] == 2)) count++;
// down
if(row<rowN-1 && (board[row+1][col] == 1 || board[row+1][col] == 2)) count++;
// prev
if(col>0 && (board[row][col-1] == 1 || board[row][col-1] == 2)) count++;
// next
if(col<colN-1 && (board[row][col+1] == 1 || board[row][col+1] == 2)) count++;
// All diagonals
if(row>0 && col>0 && (board[row-1][col-1] == 1 || board[row-1][col-1] == 2)) count++;
if(row<rowN-1 && col<colN-1 && (board[row+1][col+1] == 1 || board[row+1][col+1] == 2)) count++;
if(row>0 && col<colN-1 && (board[row-1][col+1] == 1 || board[row-1][col+1] == 2)) count++;
if(row<rowN-1 && col>0 && (board[row+1][col-1] == 1 || board[row+1][col-1] == 2)) count++;
return count;
}
}
```