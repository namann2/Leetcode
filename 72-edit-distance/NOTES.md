int n = w1.length(), m = w2.length();
if(w1.equals(w2)) return 0;
if(n == 0) return m; // delete chars
if(m == 0) return n; // insert chars
int[][]dp = new int[n+1][m+1];
// initial states
for(int i=0;i<n+1;i++)
dp[i][0] = i;
for(int j=0;j<m+1;j++)
dp[0][j] = j;
for(int i=1;i<n+1;i++) {
for(int j=1;j<m+1;j++) {
if(w1.charAt(i-1) != w2.charAt(j-1))
dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
else dp[i][j] = dp[i-1][j-1];
}
}
return dp[n][m];
}
}
```
​
# Post Submission Thoughts :
Can the solution be optimised ?
YES, since the current dp state `dp[i][j]` depends only on the previous row, we can optimise the solution.
Can the solution be optimised ?