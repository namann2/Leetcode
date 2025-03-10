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
```
