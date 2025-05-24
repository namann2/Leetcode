class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return List.of(0);
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] degree = new int[n];
        for(int[] edge : edges) {
            g.putIfAbsent(edge[0], new ArrayList<>());
            g.putIfAbsent(edge[1], new ArrayList<>());
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        int nodesRemaining = n;
        for(int i = 0; i < n; i++) {
            if(degree[i] == 1) {
                leaves.offer(i);
            }
        }

        while(nodesRemaining > 2) {
            int leafNodeCount = leaves.size();
            nodesRemaining -= leafNodeCount;
            for(int i = 0; i < leafNodeCount; i++) {
                int leafNode = leaves.poll();
                for(int neigh : g.get(leafNode)) {
                    if(--degree[neigh] == 1) {
                        leaves.offer(neigh);
                    }
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        while(!leaves.isEmpty()) {
            answer.add(leaves.poll());
        }
        return answer;
    }
}