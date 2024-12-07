## Another implementation : More intuitive <br>
We need to break the number in k >= 2. Let's break it into two ways,  <br>
1. k = 2 ( We can break a number in atleast 2 ) <br>
2. k > 2 ( We can break the broken number further ) <br>


n = 10 -> Can be broken down into <br>
1, 9 => if k >= 2, max ( 1 * 9 , break(1) * 9 , 1 * break(9) ) => where when k = 2 we have 1 * 9 and when k > 2, we have break(1) * 9 , 1 * break(9) <br>
2, 8 <br>
3, 7 <br>
4, 6 <br>
5, 5 <br>
6, 4 <br>
7, 3 <br>
8, 2 <br>
9, 1 <br>


## Solution 

```
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        // n = 1 is the base case
        // n = 2 can have a max product of 1 after being broken in 1 + 1 i.e 1 * 1
        dp[1] = dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for(int j = 1; j < i; j++) {
                int rem = i - j;
                dp[i] = Math.max(dp[i], rem * j); // k = 2
                dp[i] = Math.max(dp[i], Math.max(rem * dp[j], dp[rem] * j)); // k > 2
            }
        }
        return dp[n];
    }
}
```
