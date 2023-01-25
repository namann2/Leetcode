class Solution {
    public int closestMeetingNode(int[] edge, int n1, int n2) {
        HashMap<Integer, Integer> g = new HashMap<>();
        int n = edge.length;
        for(int i=0;i<n;i++) {
            if(edge[i] == -1) continue;
            g.put(i, edge[i]);
        }
        
        int[]A = bfs(g, new HashSet<>(), n1, n);
        int[]B = bfs(g, new HashSet<>(), n2, n);
        
        int dis = Integer.MAX_VALUE;
        int ans = -1;
        
        for(int i=0;i<n;i++) {
            if(A[i]!=-1 && B[i]!=-1) // able to reach node from both the nodes n1 and n2
                if(Math.max(A[i], B[i]) < dis)
                {
                    dis = Math.max(A[i], B[i]);
                    ans = i;
                }
        }
        
        return dis == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private int[] bfs(HashMap<Integer, Integer> g, HashSet<Integer> vis, int src, int n) {
        vis.add(src);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        int[] R = new int[n];
        Arrays.fill(R, -1);
        
        R[src] = 0;
        int dis = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int curr = q.poll();
                if(!g.containsKey(curr)) continue;
                
                int node = g.get(curr);
                if(vis.add(node)) {
                    q.add(node);
                    R[node] = dis+1;
                }
            }
            dis++;
        }
        return R;
    }
}