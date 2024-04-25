class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> l = new ArrayList<>();
        if(n <= 2) {
            for(int i = 0; i < n; i++)
                l.add(i);
            return l;
        }
        
        int[]degree = new int[n];
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        
        for(int[]edge : edges) {
            g.putIfAbsent(edge[0], new ArrayList<>());
            g.putIfAbsent(edge[1], new ArrayList<>());
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
            if(degree[i] == 1)
                q.add(i);
        
        int numRemaining = n;
        while(n > 2) {
            int size = q.size();
            n -= size;
            for(int i=0;i<size;i++) {
                int curr = q.poll();
                for(int v : g.get(curr)) {
                    degree[v] -= 1;
                    if(degree[v] == 1) q.add(v);
                }
            }
        }
        while(!q.isEmpty()) 
            l.add(q.remove());
        
        return l;
    }
}