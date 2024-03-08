​
### Bottom - up DP
​
TC : O(n)
SC : O(n)
​
```
class Solution {
public int maxProfit(int[] prices, int fee) {
int n = prices.length;
int[][]dp = new int[n+1][2];
for(int index = n - 1; index >= 0; index --) {
for(int canBuy = 0; canBuy < 2; canBuy++) {
if(canBuy == 1) {
int buy = -prices[index] + dp[index+1][0];
int notBuy = dp[index+1][1];
dp[index][1] = Math.max(buy, notBuy);
} else {
int sell = prices[index] - fee + dp[index+1][1];
int notSell = dp[index+1][0];
dp[index][0] = Math.max(sell, notSell);
}
}
}
return dp[0][1]; // why this is returned ? -> check how the recursive function is called
}
}
​
```
​
​
​
### Bottom Up Space optimised
​
TC : O(n)
SC : O(1)
​
```
class Solution {
public int maxProfit(int[] prices, int fee) {
int n = prices.length;
int[][]dp = new int[n+1][2];