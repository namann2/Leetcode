# Twisted statement : </br>
Problem 🌟 : https://leetcode.com/discuss/interview-question/702177/apple-phone-maximum-sum-of-non-adjacent-elements </br>
Solution :  https://www.youtube.com/watch?v=VT4bZV24QNo

# House Robber Solutions : 

## Recursive
```
class Solution {
    public int rob(int[] nums) {
        return robHouses(nums, 0, nums.length);
    }
    private int robHouses(int[] nums, int index, int n) {
        // base case
        if(index >= n)
            return 0;
        // main logic
        int pick = nums[index] + robHouses(nums, index + 2, n);
        int dont_pick = robHouses(nums, index + 1, n);
        return Math.max(pick, dont_pick);
    }
}
```

## Top Down
```
class Solution {
    int[]cache;
    public int rob(int[] nums) {
        int n = nums.length;
        cache = new int[n];
        Arrays.fill(cache, -1);
        return robHouses(nums, 0, n);
    }
    private int robHouses(int[] nums, int index, int n) {
        // base case
        if(index >= n)
            return 0;
        // main logic
        if(cache[index] != -1)
            return cache[index];
        int pick = nums[index] + robHouses(nums, index + 2, n);
        int dont_pick = robHouses(nums, index + 1, n);
        return cache[index] = Math.max(pick, dont_pick);
    }
}
```

## Bottom - Up
#### Converting top down into bottom-up
```
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n];
        dp[n-1] = nums[n-1];
        dp[n-2] = Math.max(nums[n-2], dp[n-1]);
        for(int i=n-2;i>=0;i--) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}
```

## Space Optimised

```
class Solution {
    public int rob(int[] nums) {
        // check notes for all approach and a bonus
        int n = nums.length;
        if(n == 1) return nums[0];
        int next2 = nums[n-1];
        int next1 = Math.max(nums[n-2], next2);
        for(int i=n-3;i>=0;i--) {
            int curr = Math.max(nums[i] + next2, next1);
            next2 = next1;
            next1 = curr;
        }
        return next1;
    }
}
```
