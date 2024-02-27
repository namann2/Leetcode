### Recursive :
​
```
​
​
```
​
​
### Top-Down DP [ Memoisation ] :
​
```
​
​
```
​
### Bottom-Up DP
​
```
int[]dp = new int[n+1];
dp[1] = 1;
for(int i=2;i<n+1;i++)
dp[i] = dp[i-1] + dp[i-2];
return dp[n];
​
```
​
​
### Space Optimised DP
​
```
​
​
​
```