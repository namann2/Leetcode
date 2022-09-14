class Solution {
    // TC : O(N), SC : O(N)
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n==1)
            return 0;
        // Since it's a tree, we don't need "visited" array
        Map<Integer, Queue<Integer>> g = getManagerToEmployeeMapping(manager);
        return bfs(g, headID, informTime);
    }
    
    private Map<Integer, Queue<Integer>> getManagerToEmployeeMapping(int[] manager) {
        int n = manager.length;
        
        Map<Integer, Queue<Integer>> g = new HashMap<>();
        
        for(int employee = 0; employee < n; employee++) {
            int mgr = manager[employee];
            g.putIfAbsent(mgr, new LinkedList<>());
            g.get(mgr).add(employee);
        }
        return g;
    }
    
    private int bfs(Map<Integer, Queue<Integer>> g, int headID, int[] informTime) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headID, 0});
        
        int total = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                int currManager = curr[0], currTime = curr[1];
                
                total = Math.max(total, currTime);
                
                if(!g.containsKey(currManager)) continue;
                
                for(int subEmployee : g.get(currManager)) {
                    q.add(new int[]{subEmployee, currTime + informTime[currManager]});
                }
            }
        }
        return total;
    }
}