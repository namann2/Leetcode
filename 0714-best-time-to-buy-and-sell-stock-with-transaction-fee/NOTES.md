1. https://www.youtube.com/watch?v=pTQB9wbIpfU
2. Haven't gone through it, but it having doubts -> go through striver solution

### Recursive Solution
TC: O(2^n)
SC : O(n)

### Top Down Recurive DP solution
TC : O(n)
SC : O(n) -> recursive stack
```
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        Integer[][]dp = new Integer[n+1][2];
        return maxProfit(prices, 0, n, 1, fee, dp);
    }
    private int maxProfit(int[] prices, int index, int n, int canBuy, int fee, Integer[][] dp) {
        // base case
        if(index == n) return 0;
        if(dp[index][canBuy] != null)
            return dp[index][canBuy];
        
        // main logic
        if(canBuy == 1) {
            int buy = -prices[index] + maxProfit(prices, index+1, n, 0, fee, dp);
            int notBuy = maxProfit(prices, index+1, n, 1, fee, dp);
            return dp[index][canBuy] = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] - fee + maxProfit(prices, index+1, n, 1, fee, dp);
            int notSell = maxProfit(prices, index+1, n, 0, fee, dp);
            return dp[index][canBuy] = Math.max(sell, notSell);
        }
    }
}
```

### Bottom - up DP

TC : O(n)
SC : O(n)

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

```



### Bottom Up Space optimised

TC : O(n)
SC : O(1)

```
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][]dp = new int[n+1][2];
        int nextDayBuy = 0, nextDayNotBuy = 0;
        for(int index = n - 1; index >= 0; index --) {
            for(int canBuy = 0; canBuy < 2; canBuy++) {
                if(canBuy == 1) {
                    int buy = -prices[index] + nextDayNotBuy; //dp[index+1][0];
                    int notBuy = nextDayBuy;
                    int currDayBuy = Math.max(buy, notBuy);
                    nextDayBuy = currDayBuy;
                } else {
                    int sell = prices[index] - fee + nextDayBuy;
                    int notSell = nextDayNotBuy;
                    int currDayNotBuy = Math.max(sell, notSell);
                    nextDayNotBuy = currDayNotBuy;
                }
            }
        }
        return nextDayBuy; 
    }
}
```
