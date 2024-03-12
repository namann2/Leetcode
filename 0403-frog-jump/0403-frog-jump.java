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