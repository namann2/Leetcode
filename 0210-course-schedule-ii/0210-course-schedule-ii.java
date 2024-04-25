class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++)
            g.add(new ArrayList<>());
            
        for(int[] p : prerequisites) {
            g.get(p[1]).add(p[0]);
        }
        
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) {
            for(int v : g.get(i))
                indegree[v]++;
        }
        
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
            if(indegree[i] == 0) 
                q.addLast(i);
        
        int[] order = new int[n];
        int index = 0;
        while(!q.isEmpty()) {
            int u = q.removeFirst();
            order[index++] = u;
            for(int v : g.get(u)) {
                indegree[v] -= 1;
                if(indegree[v] == 0) {
                    q.addLast(v);
                }
            }
        }
        
        for(int i = 0; i < n; i++)
            if(indegree[i] != 0) return new int[]{};
        
        return order;
    }
}