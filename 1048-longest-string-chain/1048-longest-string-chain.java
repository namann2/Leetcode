class Solution {
    public int longestStrChain(String[] words) {
        // TC : O(nlogn) + O(n * wl * wl)
        // SC : O(n) + O(n)
        int n = words.length;
        if(n == 1) return 1;
        
        Arrays.sort(words, (w1, w2) -> {
            return w1.length() - w2.length();
        });
        
        Map<String,Integer> map = new HashMap<>();
        
        int[]dp = new int[n];
        dp[0] = 1;
        map.put(words[0], 0);
        int maxLength = 1;
        
        for(int i = 0; i < n; i++) {
            int wl = words[i].length();
            dp[i] = 1;
            for(int j=0;j<wl;j++) {
                StringBuilder tmp = new StringBuilder(words[i]);
                String t = tmp.deleteCharAt(j).toString();
                if(map.containsKey(t) && dp[map.get(t)] + 1 > dp[i]) {
                    dp[i] = dp[map.get(t)] + 1;
                }
            }
            map.put(words[i], i);
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}