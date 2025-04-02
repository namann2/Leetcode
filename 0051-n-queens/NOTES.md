<h2>Correct TC from Solution Premium tab :</h2>
​
<h3>Time complexity: `O(N!)`</h3> <br/>
​
Unlike the brute force approach, we will only place queens on squares that aren't under attack. <br>
</br>
For the first queen, we have N options. <br>
</br>
For the next queen, we won't attempt to place it in the same column as the first queen, and there must be at least one square attacked diagonally by the first queen as well. Thus, the maximum number of squares we can consider for the second queen is N−2. <br>
</br>
For the third queen, we won't attempt to place it in 2 columns already occupied by the first 2 queens, and there must be at least two squares attacked diagonally from the first 2 queens. <br>
</br>
Thus, the maximum number of squares we can consider for the third queen is N−4. This pattern continues, resulting in an approximate time complexity of N!.<br>
​</br>
While it costs `O(N^2)` to build each valid solution, the amount of valid solutions S(N) does not grow nearly as fast as N!, </br>
so `O(N! + S(N) * N^2)` = O(N! + S(N) ∗ N^2)= `O(N!)` <br>
​

​
```
class Solution {
    boolean[] cols;
    boolean[] ndiag;
    boolean[] rdiag;
    public List<List<String>> solveNQueens(int n) {
        /*
        TC : 
        
        If for every cell, we traverse the whole matrix and check if we can 
        place the queen there or not, this will take 
        
        O(n^n) time complexity. 
        
        but as we are backtracking from a possible invalid cell
        
        for every cell, we have two options 
        1. we can place the queen 
        2. we can not place the queen
        
        i.e. 2^n
        
        and we are also copying the valid ans to our result
        
        i.e n2
        
        total : 2^n
        
        */
        List<List<String>> result = new ArrayList();
        
        char[][] board = new char[n][n];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        cols = new boolean[n];
        ndiag = new boolean[2*n-1];
        rdiag = new boolean[2*n-1];
        
        nQueens(board, 0, n, result);
        
        return result;
    }
    
    public void nQueens(char[][] board, int row, int n, List<List<String>> result) {
        
        if(row >= n) {
            ArrayList<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++) {
                StringBuilder str = new StringBuilder();
                for(int j=0;j<n;j++) {
                    str.append(board[i][j]);
                }
                temp.add(str.toString());
            }
            result.add(temp);
            return;
        }
        
        for(int col=0;col<n;col++) {
            boolean isCurrentCellSafe = isSafe(board, row, col, n);
            if(isCurrentCellSafe) {
                
                board[row][col] = 'Q';
                cols[col] = true;
                ndiag[row+col] = true;
                rdiag[row-col+board.length-1] = true;
                
                nQueens(board, row+1, n, result);
                
                board[row][col] = '.';
                cols[col] = false;
                ndiag[row+col] = false;
                rdiag[row-col+board.length-1] = false;
                
            }
        }
    }
    
    private boolean isSafe(char[][]board, int row, int col, int n) {
        if(// kya in positions pr kuch pada hai
            cols[col] == false &&
            ndiag[row+col] == false &&
            rdiag[row-col+board.length-1] == false) {
            return true;
        }
        return false;
    }
}
```
