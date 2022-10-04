# `Total number of substrings : n(n+1)/2`

# `Brute Force`
Find every substring and check if it is a palindrome.
Since we just need to traverse every substring once, the total time taken is sum of the length of all substrings.
1 + 2 + ... n = n(n+1)/2 ( check if it is palindrome i.e.O(n) thus, total becomes O(n3))


# `Expand from Centre Approach`
```
https://leetcode.com/problems/palindromic-substrings/discuss/105688/Very-Simple-Java-Solution-with-Detail-Explanation
```

# `Gap Strategy Approach`
We have to compute something on a "Substring" i.e. why I am using gap strategy. ( add more points if there are other insights as well )

Steps : 
1. Make a table and form a complete dry run for a sample string.
2. Keep in mind that we have to apply gap strategy here, so we have three things to keep in mind : 
						* gap (g)
						* row
						* col
We are moving in a digonal fashion in the grid.
3. After making deductions, write code : 

```
class Solution {
    public int countSubstrings(String s) {
        // Check Notes'
        
        if(s==null || s.length()==0) return 0;
        if(s.length() == 1) return 1;
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        
        for(int g=0;g<s.length();g++) {
            // for every gap, our "row" starts from 0
            int row = 0;
            for(int col = g;col<s.length();col++) {
                if(g==0) {
                   dp[row][col] = true; 
                } 
                else if(g==1) {
                    dp[row][col] = s.charAt(row) == s.charAt(col);
                } 
                else {
                    dp[row][col] = s.charAt(row) == s.charAt(col) && dp[row+1][col-1];
                }
                
                ans += dp[row][col] == true ? 1 : 0;
                row++; // update row and col for next diagonal cell
            }
        }
        return ans;
    }
}
```
