class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        for(int i = 0; i < n; i++) {
            String currWord = words.get(i);
            String colWord = getWord(words, n, i);
            if(!currWord.equals(colWord))
                return false;
        }
        return true;
    }
    
    private String getWord(List<String> words, int n, int index) {
        StringBuilder colWord = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String currWord = words.get(i);
            if(index < currWord.length()) 
                colWord.append(currWord.charAt(index));
        }
        return colWord.toString();
    }
}