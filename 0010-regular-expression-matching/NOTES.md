```
class Solution {
public boolean isMatch(String s, String p) {
Boolean[][]dp = new Boolean[s.length()+1][p.length()+1];
return isMatch(s, p, 0, 0, s.length(), p.length(), dp);
}
private boolean isMatch(String s, String p, int i, int j, int sn, int pn, Boolean[][] dp) {
// base condition
if(j == pn) return i==sn;
if(i<sn && j<pn && dp[i][j] != null)
return dp[i][j];
// main logic
if(j+1 < pn && p.charAt(j+1) == '*') {
if(isMatch(s, p, i, j+2, sn, pn, dp)) {
return dp[i][j] = true; // a* matches to 0
}
if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' && isMatch(s, p, i+1, j, sn, pn, dp))
return dp[i][j] = true;
} else {
if(i<sn && j<pn && s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
if(isMatch(s, p, i+1, j+1, sn, pn, dp))
return dp[i][j] = true;
}
return dp[i][j] = false;