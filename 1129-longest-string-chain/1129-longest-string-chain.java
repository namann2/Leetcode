class Solution {
    public int longestStrChain(String[] words) {
        int maxLIS = 0;
        Arrays.sort(words, (w1, w2) -> {
            return w1.length() - w2.length();
        });

        Map<String, Integer> maxChainLengthLIS = new HashMap<>();
        for(String word : words) {
            maxChainLengthLIS.put(word, 1);
            int currWordLength = word.length();
            for(int i = 0; i < currWordLength; i++) {
                String prevString = new StringBuilder(word).deleteCharAt(i).toString();
                if(maxChainLengthLIS.containsKey(prevString)) {
                    int currLIS = maxChainLengthLIS.get(prevString) + 1;
                    maxChainLengthLIS.put(word, Math.max(maxChainLengthLIS.get(word), currLIS));
                }
            }
            maxLIS = Math.max(maxLIS, maxChainLengthLIS.get(word));
        }
        return maxLIS;
    }
}