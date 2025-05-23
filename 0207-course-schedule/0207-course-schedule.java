class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // b -> a
        // check for cycles
        // since there is an order to maintain - topological sort is a good choice
        // if any indegree is not zero - not possible
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            g.putIfAbsent(prerequisite[1], new ArrayList<>());
            g.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(!g.containsKey(curr)) continue;
            for(int neigh : g.get(curr)) {
                indegree[neigh]--;
                if(indegree[neigh] == 0) 
                    q.offer(neigh);
            }
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] != 0) return false;
        }
        return true;
    }
}