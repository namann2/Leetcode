
<img width="1489" alt="Screenshot 2025-06-09 at 2 13 45 PM" src="https://github.com/user-attachments/assets/3704bd99-82e5-4792-bd81-359f67add35f" />

### Top Down Approach 


```
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, k = 2;
        Integer[][][]dp = new Integer[n+1][k+1][2];
        /* 2 options
            1. buy
            2. sell
            each option has two choices : can and can not &
            to begin a transaction - we need to buy
        */
        int option = 1; // true means -> I have the option to buy
        return maxProfit(prices, 0, n, k, 1, dp);
    }

    // helper functions

    private int maxProfit(int[] prices, int index, int n, int k, int canBuy, Integer[][][] dp) {
        // base case
        if(k == 0) return 0;
        if(index == n) return 0;
        if(dp[index][k][canBuy] != null) 
            return dp[index][k][canBuy];
        // main logic
        if(canBuy == 1) {
            int buy = -prices[index] + maxProfit(prices, index + 1, n, k, 0, dp);
            int dontBuy = maxProfit(prices, index + 1, n, k, 1, dp);
            return dp[index][k][canBuy] = Math.max(buy, dontBuy);
        } else {
            int sell = prices[index] + maxProfit(prices, index + 1, n, k-1, 1, dp);
            int dontSell = maxProfit(prices, index + 1, n, k, 0, dp);
            return dp[index][k][canBuy] = Math.max(sell, dontSell);
        }
    }
}
```

## Bottom up Solution : 

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



## State Solution : 

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
