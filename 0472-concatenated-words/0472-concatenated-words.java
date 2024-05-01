class Solution {
    Map<String, Boolean> dp = new HashMap<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> answer = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>();
        for(String word : words)
            wordSet.add(word);
        
        for(String word : words)
            if(concatenated(word, wordSet, 0))
                answer.add(word);
        
        return answer;
    }
    private boolean concatenated(String word, HashSet<String> wordSet, int cnt) {
        // base case
        if(word.length() == 0)
            return cnt >= 1;
        if(wordSet.contains(word) && cnt >= 1) 
            return true;
        String key = word +"-"+cnt;
        if(dp.containsKey(key))
            return dp.get(key);
        
        // main logic
        int n = word.length();
        for(int i = 0; i < n; i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if(wordSet.contains(prefix) && concatenated(suffix, wordSet, cnt+1)) {
                wordSet.add(word);
                dp.put(key, true);
                return true;
            }
        }
        dp.put(key, false);
        return false;
    }
}