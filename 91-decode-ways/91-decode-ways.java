class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[]dp = new int[n];

        int val = s.charAt(0)-'0';
        dp[0] = (val > 0 && val < 10) ? 1 : 0;
        
        for(int i=1;i<n;i++) {
            int ch = s.charAt(i)-'0';
            if(ch > 0 && ch < 10) 
                dp[i] = dp[i-1];
            // 1 2 2 3
            int num = Integer.parseInt(s.substring(i-1, i+1));
            if(num > 9 && num < 27)
                dp[i] += (i-2>=0 ? dp[i-2] : 1);
        }
        return dp[n-1];
    }
}