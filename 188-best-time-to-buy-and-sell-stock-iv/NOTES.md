## Top Down -> Bottom up ( See buy and seel stock iii )

```
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
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

***


# Optimal : 
```
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        int[][]dp = new int[k+1][n];
        // from O(n^2 * k) to O(nk)
        for(int trans = 1; trans <= k; trans ++) {
            int localMax = dp[trans-1][0] - prices[0];
            for(int day = 1; day < n; day ++) {
                dp[trans][day] = Math.max(dp[trans][day-1], localMax + prices[day]);
                localMax = Math.max(localMax, dp[trans-1][day] - prices[day]);
            }
        }
        
        return dp[k][n-1];
    }
}
```
