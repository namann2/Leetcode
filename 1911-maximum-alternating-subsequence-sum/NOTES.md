helper(nums, 0, 0, 0, true, n);
return ans;
}
private long helper(int[] A, int index, long sumEven, long sumOdd, boolean isEven, int n) {
// base case
if(index >= n) {
ans = Math.max(ans, sumEven - sumOdd);
return;
}
// main logic
if(isEven) {
helper(A, index+1, sumEven + A[index], sumOdd, !isEven, n);
helper(A, index+1, sumEven, sumOdd, isEven, n);
} else {
helper(A, index+1, sumEven, sumOdd + A[index], !isEven, n);
helper(A, index+1, sumEven, sumOdd, isEven, n);
}
}
}
```
​
### Optimised Memoisation Code :
​
Optimisations :
1. Less variables in recursive call
2. Optimised conversion of sign to map the index in memo array
3. Added Memoisation to compute faster
4. TC : O(n * 2) [ check the dp array variables ] -> O(n) and space of O(n)
​
```
class Solution {
public long maxAlternatingSum(int[] nums) {
int n = nums.length;
// dp state -> max alternating sum of a subsequence ending at ith index
long[][]dp = new long[n][2];
for(long[] arr : dp)
Arrays.fill(arr, -1l);
return helper(nums, 0, 1, n, dp);
}
private long helper(int[] A, int index, int sign, int n, long[][]dp) {
// base case
if(index >= n) return 0;
if(dp[index][(sign+1)/2] != -1)
return dp[index][(sign+1)/2];
// main logic
long pick = A[index] * sign + helper(A, index+1, -sign, n, dp);
long dont_pick = helper(A, index+1, sign, n, dp);
return dp[index][(sign+1)/2] = Math.max(pick, dont_pick);
}
}
```