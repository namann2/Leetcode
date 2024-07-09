class Solution {
    public int maximumDetonation(int[][] bombs) {
        // this is a directed graph : hence, UF won't work
        Map<Integer, List<Integer>> g = new HashMap<>();
        int n = bombs.length;
        
        // create a directed graph indicating the bombs a particular bomb can trigger
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                g.putIfAbsent(i, new ArrayList<>());
                g.putIfAbsent(j, new ArrayList<>());
                // if ith bomb can detonate jth bomb
                if(detonates(bombs[i], bombs[j])) {
                    g.get(i).add(j);
                }
                
                // if jth bomb can detonate ith bomb
                if(detonates(bombs[j], bombs[i])) {
                    g.get(j).add(i);
                }
            }
        }
        
        // TODO : DFS to find the max detonated bomb
        int maxBombDetonated = 0;
        for(int i = 0; i < n; i++) {
            maxBombDetonated = Math.max(maxBombDetonated, dfs(g, i, new boolean[n]));
        }
        
        return maxBombDetonated;
    }
    
    // check if A detonates B : aka whether B lies in the range of A
    private boolean detonates(int[] A, int[] B) {
        int x1 = A[0], y1 = A[1], x2 = B[0], y2 = B[1];
        // if the distance b/w the two points is less than the radius of A then, B overlaps with A
        return 1d * 1l * A[2] >= Math.sqrt((1l * (x2 - x1) * (x2 - x1)) + (1l * (y2 - y1) * (y2 - y1)));
    }
    
    // check the number of bombs a particular bomb can trigger in a ripple manner
    private int dfs(Map<Integer, List<Integer>> g, int bombIndex, boolean[] isDetonated) {
        isDetonated[bombIndex] = true;
        int bombsDetonated = 1;
        if(g.containsKey(bombIndex)) {
            for(int bombIndexInRange : g.get(bombIndex)) {
                if(!isDetonated[bombIndexInRange])
                    bombsDetonated += dfs(g, bombIndexInRange, isDetonated);
            }
        }
        return bombsDetonated;
    }
}