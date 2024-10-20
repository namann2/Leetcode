class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        int wordLength = word.length();
        if(wordLength > rows * cols) return false;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(word.charAt(0) == board[i][j]) {
                    if(dfs(board, i, j, 0, rows, cols, word, wordLength, new boolean[rows][cols]))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, int curr, int rows, int cols, String word, int wordLength, boolean[][] visited) {
        boolean isCurrentCellSafe = isSafe(board, i, j, curr, rows, cols, word, wordLength, visited);
        if(isCurrentCellSafe) {
            if(curr == wordLength - 1) return true;
            visited[i][j] = true;
            boolean l = dfs(board, i, j-1, curr + 1, rows, cols, word, wordLength, visited);
            boolean r = dfs(board, i, j+1, curr + 1, rows, cols, word, wordLength, visited);
            boolean u = dfs(board, i-1, j, curr + 1, rows, cols, word, wordLength, visited);
            boolean d = dfs(board, i+1, j, curr + 1, rows, cols, word, wordLength, visited);
            if(l || r || u || d) return true;
            visited[i][j] = false;
        }
        return false;
    }
    
    private boolean isSafe(char[][]board, int i, int j, int curr, int rows, int cols, String word, int wordLength, boolean[][] visited) {
        if(i >= 0 && i < rows && j >= 0 && j < cols && !visited[i][j] && curr < wordLength && word.charAt(curr) == board[i][j])
            return true;
        return false;
    }
}