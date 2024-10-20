# Indeed Q : 
Find the coordinates of cells that match a word : 
```
class Solution {
    ArrayList<int[]> ans;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        int rows = board.length, cols = board[0].length;
        boolean res = false;
        ans = new ArrayList<>();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, i, j, rows, cols, 0, word))
                    {
                        res = true;
                        break;
                    }
                }
            }
        }
        int l = ans.size();
        System.out.println("------"); // going from back to front as we add coordinates while backtracking
        for(int i=l-1;i>=0;i--) {
            int[]d = ans.get(i);
            System.out.print(d[0]+" : "+d[1]+"\n");
        }
        return res;
    }
    private boolean dfs(char[][]g, int i, int j, int rows, int cols, int index, String word) {
        if(index >= word.length()) 
            return true;
        boolean isCurrentCellSafe = isSafe(g, i, j, rows, cols, index, word);
        boolean result = false;
        if(isCurrentCellSafe) {
            // ans.add(new int[]{i, j});
            char org = g[i][j];
            g[i][j] = '*';
            
            result = dfs(g, i+1, j, rows, cols, index + 1, word) ||
                        dfs(g, i-1, j, rows, cols, index + 1, word) ||
                            dfs(g, i, j-1, rows, cols, index + 1, word) ||
                                dfs(g, i, j+1, rows, cols, index + 1, word);
            
            if(result) ans.add(new int[]{i, j});
            
            g[i][j] = org;
        }
        return result;
    }
    private boolean isSafe(char[][]g, int i, int j, int rows, int cols, int index, String word) {
        if(i>=0 && i<rows && j>=0 && j<cols && g[i][j] == word.charAt(index))
            return true;
        return false;
    }
}
```

***

## Complexity :
 > TC : O(3^min(L,N)) SC : O(L) <br>
 > L : length of word, N : number of cells
```
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(word.charAt(0) == board[i][j]) {
                    if(dfs(board, 0, i, j, rows, cols, word)) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int idx, int i, int j, int rows, int cols, String word) {
        if(idx == word.length()) return true;
        
        boolean isCurrentCellSafe = isSafe(board, idx, i, j, rows, cols, word);
        // we had to make a variable here, rather than just returning the nested dfs statements because we have to revert back the characters
        boolean result = false;
        
        if(isCurrentCellSafe) {
            char ch = board[i][j];
            board[i][j] = '-';
            
            result = dfs(board, idx+1, i+1, j, rows, cols, word) || 
            dfs(board, idx+1, i-1, j, rows, cols, word) ||
            dfs(board, idx+1, i, j+1, rows, cols, word) ||
            dfs(board, idx+1, i, j-1, rows, cols, word);
            
            board[i][j] = ch;
        }
        return result;
    }
    private boolean isSafe(char[][]board, int idx, int i, int j, int rows, int cols, String word) {
        if(i>=0 && j>=0 && i<rows && j<cols && word.charAt(idx) == board[i][j]) {
            return true;
        }
        return false;
    }
}
```
