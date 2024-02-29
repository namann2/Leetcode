​
# Basic Iteration
TC : `O(n + m)`
SC : `O(1)`
​
```
class Solution {
public boolean isSubsequence(String s, String t) {
int n = s.length(), m = t.length();
if(n > m) return false;
int i = 0, j = 0;
while(i < n && j < m) {
if(s.charAt(i) == t.charAt(j)) {
i++;
j++;
} else j++;
}
return i == n;
}
}
```
​
# Longest Common Subsequnce :
See whether the length of LCS is equal to the `s`
TC : `O(n * m)`
SC : `O(n * m)`
​
```
class Solution {
public boolean isSubsequence(String s, String t) {
// if s is a subsequence-> [], "a", "b", "c", "......"
if(s==null || s.length()==0) return true;
if(t==null || t.length()==0) return false;
int n = s.length(), m = t.length();
int[][]dp = new int[n+1][m+1];
for(int i=1;i<n+1;i++) {
for(int j=1;j<m+1;j++) {
if(s.charAt(i-1) == t.charAt(j-1)) {
dp[i][j] = 1 + dp[i-1][j-1];
}
else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
}
}
return dp[n][m] == Math.min(n,m);
}
}
```