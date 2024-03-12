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