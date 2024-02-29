```
class Solution {
public int numSquares(int n) {
if(n==1) return 1;
int[]dp = new int[n+1];
dp[0] = 0;
dp[1] = 1;
for(int i=2;i<n+1;i++) {
dp[i] = Integer.MAX_VALUE;
for(int j=1;j*j<=i;j++) {
dp[i] = Math.min(dp[i], dp[i-j*j]);
}
dp[i] = dp[i] + 1; // we have used 1 number from the
}
// System.out.println(Arrays.toString(dp));
return dp[n];
}
}
```