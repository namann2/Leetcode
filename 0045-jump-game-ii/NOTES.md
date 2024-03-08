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

# O(N)

Intuition : 
https://www.youtube.com/watch?v=vBdo7wtwlXs

```
class Solution {
    public int jump(int[] A) {
        int n = A.length;
        // This is an optimal solution. Check Notes
        int jumps = 0, farthest = 0, currEnd = 0;
        for(int i=0;i<n-1;i++) { // n-1 because we do not want to reach the state where i == n-1
            farthest = Math.max(farthest, A[i]+i);
            if(i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
            // early break condition
            if(currEnd >= n) break;
        }
        return jumps;
    }
}
```
