```
class Solution {
public boolean isMatch(String s, String p) {
int n = s.length(), m = p.length();
Boolean[][] dp = new Boolean[n+1][m+1];
return regexMatch(s, p, 0, 0, n, m, dp);
}
private boolean regexMatch(String s, String p, int i, int j, int n, int m, Boolean[][] dp) {
if(i == n && j == m) return true;
if(i > n || j > m) return false;
if(dp[i][j] != null) return dp[i][j];
if(j+1 < m && p.charAt(j+1) == '*') {
boolean zeroMatch = regexMatch(s, p, i, j+2, n, m, dp);
if(zeroMatch) return dp[i][j] = true;
// one or more match
if(i < n && j < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) // consider ba with a* : in this case we need to return false
if(regexMatch(s, p, i+1, j, n, m, dp))
return dp[i][j] = true;
} else {
if(i < n && j < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
if(regexMatch(s, p, i+1, j+1, n, m, dp))
return dp[i][j] = true;
}
}
return dp[i][j] = false;
}
}
```