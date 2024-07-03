class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        // sort the words by length
        Arrays.sort(words, (w1, w2) -> {
            return w1.length() - w2.length();
        });
        
        // this seems like an application of LIS
        Map<String, Integer> wordLIS = new HashMap<>();
        wordLIS.put(words[0], 1);
        
        int maxLength = 1;
        
        for(int i = 1; i < n; i++) {
            String currWord = words[i];
            int wordLength = currWord.length();
            int currLIS = 1;
            for(int j = 0; j < wordLength; j++) {
                String newStr = new StringBuilder(currWord).deleteCharAt(j).toString();
                if(wordLIS.containsKey(newStr)) {
                    currLIS = Math.max(currLIS, 1 + wordLIS.get(newStr));
                }
            }
            wordLIS.put(currWord, currLIS);
            maxLength = Math.max(maxLength, currLIS);
        }
        
        return maxLength;
    }
}