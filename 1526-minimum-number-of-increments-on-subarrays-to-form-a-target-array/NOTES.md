​https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/discuss/1336545/Intuitive-DP-solution

Options to think : 
1. Greedy (doesn't really align here)
2. BFS (for each number we will have to choose for number of ways we can reach -> O(n) * O(max(target[i])) -> TLE
3. DP 📢


### DP-01
```
class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int[]dp = new int[n];
        dp[0] = target[0];
        for(int i = 1; i < n; i++) {
            if(target[i] > target[i-1]) dp[i] = dp[i-1] + target[i] - target[i-1];
            else if(target[i] <= target[i-1]) dp[i] = dp[i-1];
        }
        return dp[n-1];
    }
}
```

<hr>

### DP-01-Optimal

```
class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int[]dp = new int[n];
        dp[0] = target[0];
        for(int i = 1; i < n; i++) {
            dp[i] = dp[i-1];
            if(target[i] > target[i-1]) dp[i] += target[i] - target[i-1];
        }
        return dp[n-1];
    }
}
```

<hr>

### DP-01-Optimal

```
class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int prev = target[0];
        int curr = 0;
        for(int i = 1; i < n; i++) {
            curr = prev;
            if(target[i] > target[i-1]) curr += target[i] - target[i-1];
            prev = curr;
        }
        return prev;
    }
}
```
