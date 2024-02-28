## What was different about this question ?

Given an array nums, return the maximum alternating sum of any subsequence of nums (**after reindexing the elements of the subsequence**).

- Could not understand the meaning of this. What does it mean ? Say, we have an input [4,2,5,3]. Say, index = 0, If we decide to pick the element at this index, then next index will be 1 right. yes, correct. [4,2,5,3] with index [0,1,2,3] .
- What if we do not pick this current element ? then the next element's index will be 0 and not 1. Since now the subsequence is [2,5,3] with index [0,1,2]

Please keep in mind this idea.


### First Attempt Recursion : 

Drawback of this attempt / What needs to be improved :

1. Too many variables in recursive call, which will make it difficult to convert the code to dynamic programming.
2. global variable
3. complex/unclean implementation
4. TC : O(2^n), for every index there are two possibility pick or do not pick.

```
class Solution {
		long ans = Long.MIN_VALUE;
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
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

### Optimised Memoisation Code : 

Optimisations : 
1. Less variables in recursive call
2. Optimised conversion of sign to map the index in memo array
3. Added Memoisation to compute faster
4. TC : O(n * 2) [ check the dp array variables ] -> O(n) and space of O(n)

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
