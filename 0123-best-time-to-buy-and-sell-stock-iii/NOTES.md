public int maxProfit(int[] prices) {
// main logic
if(canBuy == 1) {
int buy = -prices[index] + maxProfit(prices, index+1, 0, n, k, dp);
int notBuy = maxProfit(prices, index+1, 1, n, k, dp);
return dp[index][canBuy][k] = Math.max(buy, notBuy);
} else {
int sell = prices[index] + maxProfit(prices, index+ 1, 1, n, k-1, dp);
int notSell = maxProfit(prices, index+1, 0, n, k, dp);
return dp[index][canBuy][k] = Math.max(sell, notSell);
}
}
}
```
​
## Bottom up Solution :
​
```
class Solution {
public int maxProfit(int[] prices) {
int n = prices.length, k = 2;
int[][][]dp = new int[n+1][2][k+1];
// TC : O(n * k)
// SC : O(nk)
for(int index = n - 1; index >= 0; index --) {
for(int canBuy = 0; canBuy < 2; canBuy ++) {
for(int trans = 1; trans <= k; trans ++) {
if(canBuy == 1) {
int buy = -prices[index] + dp[index+1][0][trans];
int notBuy = dp[index+1][1][trans];
dp[index][canBuy][trans] = Math.max(buy, notBuy);
} else {
int sell = prices[index] + dp[index+1][1][trans-1];
int notSell = dp[index+1][0][trans];
dp[index][canBuy][trans] = Math.max(sell, notSell);
}
}
}
}
return dp[0][1][2];
}
}
```
​
​
​
## State Solution :
​
```
class Solution {
public int maxProfit(int[] prices) {
int min = Integer.MIN_VALUE;
int A = min, B = min, C = min, D = min;
for(int price : prices) {
A = Math.max(A, - price); // buy or not buy
B = Math.max(B, A + price); // sell or not sell, B is the resultant profit after a transaction
C = Math.max(C, B - price); // buy or not buy second time
D = Math.max(D, C + price);
}
return D;
}
}
```