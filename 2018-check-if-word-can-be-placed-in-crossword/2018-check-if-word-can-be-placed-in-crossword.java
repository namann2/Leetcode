class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        char[][] transpose = new char[m][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                transpose[j][i] = board[i][j];
            }
        }
        
//         for(char[] row : board)
//             System.out.println(Arrays.toString(row));
        
//         for(char[] row : transpose)
//             System.out.println(Arrays.toString(row));
        
        return canPlaceInCrossWord(board, word) || canPlaceInCrossWord(transpose, word);
    }
    
    private boolean canPlaceInCrossWord(char[][] board, String word) {
        
        // find words that need to be placed
        String wordsToMatch[] = new String[]{word, new StringBuilder(word).reverse().toString()};
        System.out.println(Arrays.toString(wordsToMatch));
        // iterate over the board and check if String can be placed in the row
        for(char [] row : board) {
            // find all space
            String canPlaceSpace[] = new String(row).split("#");
            
            // check if words can be fit in the space available in the current row
            for(String words : wordsToMatch) {

                int wLength = words.length();
                for(String space : canPlaceSpace) {
                    if(space.length() == wLength) { // check if there is no extra space on left and right
                        int i = 0; 
                        while(i < wLength && (words.charAt(i) == space.charAt(i) || space.charAt(i) == ' ')) i++;
                        if(i == wLength) return true;
                    }
                }
            }
        }
        return false;
    }
}