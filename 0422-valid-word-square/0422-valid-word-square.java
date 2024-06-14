class Solution {
    public boolean validWordSquare(List<String> words) {

        int n = words.size();
        for(int i = 0; i < n; i++) {
            String rowWord = words.get(i);
            String colWord = getColumnWord(words, i, n);
            if(!rowWord.equals(colWord))
                return false;
        }
        return true;
    }
    
    private String getColumnWord(List<String> words, int index, int n) {
        StringBuilder colWord = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String currWord = words.get(i);
            if(index < currWord.length())
                colWord.append(currWord.charAt(index));
            else break;
        }
        return colWord.toString();
    }
}