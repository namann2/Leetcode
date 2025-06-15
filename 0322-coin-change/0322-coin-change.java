class Solution {
    public int coinChange(int[] coins, int A) {
        int n = coins.length;
        // dp state = min number of coins required to make Ath amount from coins till ith index
        int[][]dp = new int[n][A+1];
        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        int[]prev = new int[A+1];
        Arrays.fill(prev, Integer.MAX_VALUE);

        // step 1 : base case
        prev[0] = 0;
        
        for(int amount = 0; amount < A + 1; amount++) {
            if(amount % coins[0] == 0) prev[amount] = amount / coins[0];
        }

        // step 2 : iteration 
        for(int index = 1; index < n; index ++) {
            int[] curr = new int[A + 1];
            for(int amount = 0; amount < A + 1; amount++) {
                int skip = prev[amount];
                int take = Integer.MAX_VALUE;
                if(coins[index] <= amount) {
                    int numberOfCoinsUsed = curr[amount - coins[index]];
                    if(numberOfCoinsUsed != Integer.MAX_VALUE)
                        take = numberOfCoinsUsed + 1;
                } 
                curr[amount] = Math.min(take, skip);
            }
            prev = curr;
        }

        // step 3 : return statement
        return prev[A] == Integer.MAX_VALUE ? -1 : prev[A];
    }
}