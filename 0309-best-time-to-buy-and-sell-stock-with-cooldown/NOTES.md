### Top Down Approach :
​
```
class Solution {
public int maxProfit(int[] prices) {
int n = prices.length;
int[][]dp = new int[n+1][2];
for(int[] row : dp)
Arrays.fill(row, -1);
return maxProfit(prices, 0, n, 1, 1, dp);
}
private int maxProfit(int[] prices, int index, int n, int canBuy, int coolDown, int[][]dp) {
// base case
if(index >= n) return 0;
if(dp[index][canBuy] != -1)
return dp[index][canBuy];
// main logic
if(canBuy == 1) {
int buy = -prices[index] + maxProfit(prices, index + 1, n, 0, coolDown, dp);
int notBuy = maxProfit(prices, index + 1, n, 1, coolDown, dp);
return Math.max(buy, notBuy);
} else {
int sell = prices[index] + maxProfit(prices, index + 1 + coolDown, n, 1, coolDown, dp);
int notSell = maxProfit(prices, index + 1, n, 0, coolDown, dp);
return Math.max(sell, notSell);
}
}
}
```
​
​
​
------------------------------------------------------------------------------------
​
Pointers :
1. CodeBix Solution : Top Down DP
2. My intuition explanation
​
****
# Codebix : Video Tutorial : Top Down
```
class Solution {
enum STATE {
BUY, SELL;
}
HashMap<String, Integer> map = new HashMap<>();
public int maxProfit(int[] A) {
if(A == null || A.length == 0) return 0;
return maxProfit(A, 0, A.length, STATE.BUY);
}
private int maxProfit(int[]A, int index, int n, STATE state) {
// base case
if(index >= n)
​