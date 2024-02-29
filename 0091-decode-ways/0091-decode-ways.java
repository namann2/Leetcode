class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[]dp = new int[n+1];
        /*
            dp state = number of ways to decode a string ending at ith index
            TC : O(n)
            SC : O(n)
            Since we are only dependent on previous two values, we can 
            save space.
            
            prev1 = single digit
            prev2 = double digit
            
            ----- ---- ------- 
            prev2 prev1 current
        */
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i=2;i<n+1;i++) {
            int single_digit = s.charAt(i-1) - '0';
            if(single_digit >= 1 && single_digit <= 9) 
                dp[i] = dp[i-1];
            int double_digit = Integer.valueOf(s.substring(i-2, i));
            if(double_digit > 9 && double_digit <= 26)
                dp[i] += dp[i-2];
        }
        return dp[n];
        
        /*
        int prev2 = 1, prev1 = s.charAt(0) == '0' ? 0 : 1;
        for(int i=2;i<n+1;i++) {
            int current = 0;
            int single_digit = s.charAt(i-1) - '0';
            if(single_digit >= 1 && single_digit <= 9) 
                current = prev1;
            int double_digit = Integer.valueOf(s.substring(i-2, i));
            if(double_digit > 9 && double_digit <= 26)
                current += prev2;
            
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
        */
    }
}