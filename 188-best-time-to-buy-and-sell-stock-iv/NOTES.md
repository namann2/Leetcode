# Acceptable
```
class Solution {
public int maxProfit(int k, int[] prices) {
if(prices == null || prices.length == 0) return 0;
int n = prices.length;
int[][]dp = new int[k+1][n];
for(int i=1;i<k+1;i++) {
for(int j=1;j<n;j++) {
dp[i][j] = dp[i][j-1] + ;
for(int m=0;m<j;m++) {
dp[i][j] = Math.max(dp[i][j], dp[i-1][m] - prices[m] + prices[j]);
}
}
}
// O(n^2 * k) -> O(n * k)
return dp[k][n-1];
}
}
```
​
***
​
​
# Optimal :
```