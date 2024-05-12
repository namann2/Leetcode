class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> forbids = new HashSet<>(forbidden);
        int n = word.length();
        int start = 0, maxLength = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j >= Math.max(start, i - 10); j--) {
                String subs = word.substring(j, i+1);
                if(forbids.contains(subs)) {
                    start = j + 1;
                    break;
                }
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}