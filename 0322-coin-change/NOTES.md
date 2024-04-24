## Approach 1  : This is same as finding combinations to make a particular target.
As, we can use a coin any number of times, therefore, it would be better to use for loop approach ( For more info, 
check notes section of combination problem )


This is not a good approach since we are storing the coins which is not helpful as it is not required.
`TC : O(2^n)`

```
class Solution {
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        cc(coins, 0, new ArrayList<Integer>(), amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private void cc(int[] coins, int index, ArrayList<Integer>temp, int k) {
        
        if(index>=coins.length) return;
        
        if(k == 0) {
            ans = Math.min(ans, temp.size());
            return;
        }
        if(k<0) return;
        
        temp.add(coins[index]);
        cc(coins, index, temp, k-coins[index]);
        temp.remove(temp.size()-1);
        
        cc(coins, index+1, temp, k);
    }
}
```

## Approach 2 : Optimising above approach : 

```
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][]dp = new int[n + 1][amount + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int ans = coinChange(coins, 0, n, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int coinChange(int[] coins, int index, int n, int target, int[][]dp) {
        // base case
        if(target == 0) {
            // min = Math.min(min, new ArrayList<>(temp).size());
            return 0;
        }
        if(target < 0) return Integer.MAX_VALUE;
        if(index == n) return Integer.MAX_VALUE;
        if(dp[index][target] != -1)
            return dp[index][target];
        // main logic
        int ans = Integer.MAX_VALUE;
        for(int i = index; i < n; i++) {
            int x = coinChange(coins, i, n, target - coins[i], dp);
            if(x != Integer.MAX_VALUE) ans = Math.min(ans, 1 + x);
        }
        return dp[index][target] = ans;
    }
}


```


## Approach 3 : 
DP 

```
class Solution {
    public int coinChange(int[] coins, int k) {
        if(coins == null || coins.length == 0) return 0;
        
        int n = coins.length;
        
        return cc(coins, n, k);
    }
    public int cc(int[] coins, int n, int amount) {
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0; // min num of coin to make amount i
        for(int i=1;i<amount+1;i++) {
            for(int coin : coins) {
                if(i==coin) {
                    dp[i] = 1;
                }
                else if(i-coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount] ;
    }
}
```
