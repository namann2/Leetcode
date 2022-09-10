class Solution {
    public int largestVariance(String s) {
        // largest : greedy, dp, brute force, backtracking, bs
        // since, we need to find largest variance possible among "ALL" substrings -> hence, brute force
        
        int A = maxVariance(s);
        
        String rev = String.valueOf(new StringBuilder(s).reverse());
        int B = maxVariance(rev);
        
        return Math.max(A, B);
    }
    
    private int maxVariance(String s) {
        // vairance = cnt1 - cnt2
        // to maximize variance -> cnt1 should increase and cnt2 should decrease
        int n = s.length();
        int max = 0;
        for(char c1 = 'a'; c1 <= 'z'; c1 ++ ) {
            for(char c2 = 'a'; c2 <= 'z'; c2 ++ ) {
                int cnt1 = 0, cnt2 = 0;
                for(int i = 0; i < n; i ++) {
                    char ch = s.charAt(i);
                    if(ch == c1) cnt1++;
                    if(ch == c2) cnt2++;
                    if(cnt1 > 0 && cnt2 > 0) max = Math.max(max, cnt1 - cnt2);
                    if(cnt2 > cnt1) cnt1 = cnt2 = 0;
                }
            }
        }
        return max;
    }
}