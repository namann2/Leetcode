### 1. Recursive : 

```
class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
}
```


### 2. Top-Down DP [ Memoisation ] : 

```
class Solution {
    public int fib(int n) {
        int[]memo = new int[n+1];
        Arrays.fill(memo, -1);
        memo[0] = memo[1] = 1;
        fib_helper(n, memo);
        return memo[n];
    }
    private int fib_helper(int n, int[] memo) {
        if(n <= 1) return n;
        if(memo[n] != -1) 
            return memo[n];
        return memo[n] = fib_helper(n-1, memo) + fib_helper(n-2, memo);
    }
}
```

### 3. Bottom-Up DP

```
int[]dp = new int[n+1];
dp[1] = 1;
for(int i=2;i<n+1;i++)
	dp[i] = dp[i-1] + dp[i-2];
return dp[n];

```


### 4. Space Optimised DP

```
if(n == 0) return 0;
int prev1 = 1, prev2 = 1, curr = 1;
for(int i=3;i<n+1;i++) {
		curr = prev1 + prev2;
		prev1 = prev2;
		prev2 = curr;
}
return curr;
```
