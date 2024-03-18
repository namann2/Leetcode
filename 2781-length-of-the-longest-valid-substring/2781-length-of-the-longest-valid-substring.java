class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        // TC : O(len + n)
        // SC : O(len)
        int ans = 0;
        Set<String> forbid = new HashSet<>(forbidden); // O(len)
        int start = 0, n = word.length();
        for(int i = 0; i < n; i ++) { // O(n)
            for(int j = Math.max(0, i); j >= Math.max(start, i-10); j--) { // O(10)
                String curr = word.substring(j, i+1);
                if(forbid.contains(curr)) { // O(1)
                    start = j + 1;
                    break;
                }
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}