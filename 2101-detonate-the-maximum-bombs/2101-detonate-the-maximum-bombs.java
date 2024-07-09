class Solution {
    public int maximumDetonation(int[][] bombs) {
        // this is a directed graph : hence, UF won't work
        Map<Integer, List<Integer>> g = new HashMap<>();
        int n = bombs.length;
        
        // create a directed graph indicating the bombs a particular bomb can trigger
        // O(n^2)
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
        for(int i = 0; i < n; i++) { // O(n)
            maxBombDetonated = Math.max(maxBombDetonated, dfs(g, i, new boolean[n])); // O(n^2)
        }
        
        return maxBombDetonated;
        
        // TC of solution : O(n^3) 
        // SC of solution : O(n^2) : 
        /* 
            In an adjacency list representation of a graph: 
            Keys: There are n nodes (bombs), so there are n keys in the adjacency list.
            Mappings: In the worst-case scenario, each node (bomb) can influence all other n−1 nodes (bombs).
            
            Hence, O(n * n-1) => O(n^2)
        */
    }
    
    // check if A detonates B : aka whether B lies in the range of A
    private boolean detonates(int[] A, int[] B) {
        int x1 = A[0], y1 = A[1], x2 = B[0], y2 = B[1];
        // if the distance b/w the two points is less than the radius of A then, B overlaps with A
        return 1d * 1l * A[2] >= Math.sqrt((1l * (x2 - x1) * (x2 - x1)) + (1l * (y2 - y1) * (y2 - y1)));
    }
    
    // check the number of bombs a particular bomb can trigger in a ripple manner
    // TC : O(V + E) : V = n (the number of bombs) and E is at most n^2 (since there can be up to n*(n-1) edges in the worst case).
    // SC : O(V)
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