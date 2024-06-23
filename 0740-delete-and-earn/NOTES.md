```
class Solution {
public int deleteAndEarn(int[] A) {
int n = A.length;
if(n==1) return A[0];
int maxValue = 0;
for(int val : A)
maxValue = Math.max(maxValue, val);
int[] count = new int[maxValue+1];
for(int i=0;i<n;i++) {
count[A[i]]++;
}
// calculate the contribution
for(int i=0;i<n;i++) {
count[A[i]] *= i;
}
int[]dp = new int[maxValue];
dp[0] = count[0];
dp[1] = count[1];
int max = 0;
for(int i=2;i<maxValue+1;i++) {
dp[i] = Math.max(dp[i]+dp[i-2], dp[i-1]);
max = Math.max(max, dp[i]);