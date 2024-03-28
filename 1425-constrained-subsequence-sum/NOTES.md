## Naive Approach : Classic LIS [ TLE ]
​
```
class Solution {
public int constrainedSubsetSum(int[] nums, int k) {
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
int n = nums.length;
int[]dp = new int[n];
dp[0] = nums[0];
int maxsum = dp[0];
for(int i = 1; i < n; i++) {
int currsum = nums[i];
for(int j = Math.max(0, i-k); j < i; j++) {
currsum = Math.max(currsum, dp[j] + nums[i]);
}
dp[i] = currsum;
maxsum = Math.max(maxsum, dp[i]);
}
return maxsum;
}
}
```
​
# Optimal Approach : Heaps
```
class Solution {
return maxsum;