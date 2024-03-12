What we need to be aware of : 

1. We need to prevent frog from hopping at the same position forever. ( hence, k-1 > 0)
2. For a particular index, given the jump we need to mark it visited. Marking the index visited based on the number of jumps is important, since it is a variable that makes the reach possible. It is possible to reach a particular index with many different jumps, and also possible that we are reaching the particular index with same jumps several times. If we have traversed the jumps ahead from it and we know that we are not able / able to reach the final index from this index ( given this particular jump ), we need to store it to avoid re-computation in later times. hence, dp is used & visited hashset stores the int[] with index and jump.


Map is required to know in O(1) whether it is possible to reach next index with k jump.

Below is my first attempt ( working, but not refactored ) : 

TODO : Bottom-up Approach

# Solution 1 : 1st attempt 👍 
```
class Solution {
    HashSet<int[]> visited = new HashSet<>();
    Boolean[][]dp;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        
        if(stones[1] != 1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        
        
        dp = new Boolean[n+1][n+1];
        for(int i = 1; i < n ; i++) 
            map.put(stones[i], i);
        
        visited.add(new int[]{1, 1}); // index, jump
        
        return canCross(stones, 1, 1, n, map);
    }
    private boolean canCross(int[] stones, int index, int k, int n, Map<Integer, Integer> map) {
        // base case
        if(index >= n-1)
            return true;
        
        if(dp[index][k] != null)
            return dp[index][k];
        // main logic
        // k - 1 jump
        boolean op1 = false, op2 = false, op3 = false;
        
        if(k - 1 > 0 && map.containsKey(stones[index] + k - 1) && visited.add(new int[]{stones[index] + k - 1, k - 1}))
            op1 = canCross(stones, map.get(stones[index] + k - 1), k - 1, n, map);
        
        if(op1) return true;
        // k jump
        if(map.containsKey(stones[index] + k) && visited.add(new int[]{stones[index] + k, k}))
            op2 = canCross(stones, map.get(stones[index] + k), k , n, map);
        
        if(op2) return true;
        // k+1 jump
        if(map.containsKey(stones[index] + k + 1) && visited.add(new int[]{stones[index] + k + 1, k + 1}))
            op3 = canCross(stones, map.get(stones[index] + k + 1), k + 1, n, map);
        
        if(op3) return true;
        
        return dp[index][k] = op1 || op2 || op3;
    }
}
```

## Solution 2 : ( Top - Down optimal )

```
class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        
        if(stones[1] != 1) return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        HashSet<int[]> visited = new HashSet<>();
        Boolean[][]dp = new Boolean[n+1][n+1];
        
        for(int i = 1; i < n ; i++) 
            map.put(stones[i], i);
        
        visited.add(new int[]{1, 1}); // index, jump
        
        return canCross(stones, 1, 1, n, map, visited, dp);
    }
    private boolean canCross(int[] stones, int index, int k, int n, Map<Integer, Integer> map, HashSet<int[]> visited, Boolean[][]dp) {
        // base case
        if(index >= n-1)
            return true;
        
        if(dp[index][k] != null)
            return dp[index][k];
        
        // main logic
        for(int jump = k - 1; jump <= k + 1; jump ++) {
            if(jump > 0 && map.containsKey(stones[index] + jump) && visited.add(new int[]{stones[index] + jump, jump}))
                if(canCross(stones, map.get(stones[index] + jump), jump, n, map, visited, dp))
                    return dp[index][k] = true;
        }
        
        return dp[index][k] = false;
    }
}

```
