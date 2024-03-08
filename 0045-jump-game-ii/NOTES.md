# N^2
```
class Solution {
public int jump(int[] A) {
int n = A.length;
Integer[]dp = new Integer[n];
dp[n-1] = 0;
for(int i=n-2;i>=0;i--) {
int jumps = A[i];
int min = Integer.MAX_VALUE;
for(int j=1;j<=jumps && i+j<n;j++) {
if(dp[i+j] != null)
min = Math.min(min, dp[i+j]);
}
if(min != Integer.MAX_VALUE)
dp[i] = 1 + min;
}
return dp[0];
}
}
```
​
# O(N)
​
Intuition :
https://www.youtube.com/watch?v=vBdo7wtwlXs