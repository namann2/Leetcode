class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) {
            List<Integer> l = new ArrayList<>();
            l.add(0);
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
        while(numRemaining > 2) {
            int size = q.size();
            numRemaining -= size;
            for(int i=0;i<size;i++) {
                int curr = q.poll();
                for(int v : g.get(curr)) {
                    degree[v]--;
                    if(degree[v] == 1) q.add(v);
                }
            }
        }
        return new ArrayList<>(q);
    }
}