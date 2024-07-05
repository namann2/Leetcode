class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int[] relation : relations) {
            g.putIfAbsent(relation[0], new ArrayList<>());
            g.get(relation[0]).add(relation[1]);
        }
        
        // this can be done with above step
        int[] indegree = new int[n+1];
        for(int[] relation : relations) {
            indegree[relation[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < n+1; i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }
        
        if(q.isEmpty()) return -1;
        
        int semester = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int curr = q.poll();
                if(!g.containsKey(curr)) continue;
                for(int next : g.get(curr)) {
                    indegree[next]--;
                    if(indegree[next] == 0) q.offer(next);
                }   
            }
            semester++;
        }
        
        for(int i = 1; i < n+1; i++)
            if(indegree[i] != 0) return -1;
        
        return semester - 1;
    }
}