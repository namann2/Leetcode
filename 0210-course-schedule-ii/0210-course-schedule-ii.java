class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] prerequisite : prerequisites) {
            g.putIfAbsent(prerequisite[1], new ArrayList<>());
            // [a,b] means b -> a 
            g.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        int[] answer = new int[numCourses];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        int completedCourses = 0;
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                completedCourses++;
                answer[idx++] = i;
            }
        }

        while(!q.isEmpty()) {
            int currCourse = q.poll();
            if(!g.containsKey(currCourse)) continue;
            for(int v : g.get(currCourse)) {
                if(--indegree[v] == 0) {
                    q.offer(v);
                    completedCourses++;
                    answer[idx++] = v;
                }
            }
        }

        return completedCourses == numCourses ? answer : new int[]{};
    }
}