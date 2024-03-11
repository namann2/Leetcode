## Bottom - up solution  [ TLE ]
​
```
class Solution {
public int maxResult(int[] nums, int k) {
int n = nums.length;
int[] dp = new int[n];
int maxScore = nums[n-1];
dp[n-1] = nums[n-1];
for(int i = n - 2; i >= 0; i--) {
dp[i] = Integer.MIN_VALUE;
for(int j = i + 1; j <= Math.min(n - 1, i + k); j++) {
dp[i] = Math.max(dp[i], nums[i] + dp[j]);
}
}
return dp[0];
}
}
```
​
What essentially we are doing is, for a particular index we are checking the largest value ahead of it. Can we find it some other way ?
​