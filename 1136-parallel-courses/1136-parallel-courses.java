class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++) 
            g.add(new ArrayList<>());
        
        int[] indegree = new int[n];
        for(int[] rel : relations) {
            g.get(rel[0]-1).add(rel[1]-1);
            indegree[rel[1]-1]++;
        }
        
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
            if(indegree[i] == 0) q.addLast(i);
        
        // this indicates that there is no node with 0 indegree i.e. no node can be a start 
        if(q.size() == 0) return -1;
        
        int semester = 0;
        while(!q.isEmpty()) {
            int k = q.size();
            for(int i = 0; i < k; i++) {
                int u = q.removeFirst();
                for(int v : g.get(u)) {
                    indegree[v] -= 1;
                    if(indegree[v] == 0) {
                        q.addLast(v);
                    }
                }
            }
            semester++;
        }
        
        for(int i = 0; i < n; i++)
            if(indegree[i] != 0) return -1;
        
        return semester;
    }
}