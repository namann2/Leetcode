class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> forbid = new HashSet<>(forbidden);
        int maxLength = 0, n = word.length(), stop = 0;
        for(int end = 0; end < n; end++) {
            for(int start = end; start >= Math.max(end - 10, stop); start--) {
                String curr = word.substring(start, end + 1);
                if(forbid.contains(curr)) {
                    stop = start + 1;
                    break;
                }
            }
            maxLength = Math.max(maxLength, end - stop + 1);
        }
        return maxLength;
    }
}