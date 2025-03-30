class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return List.of(0);
        int[] degree = new int[n];
        Map<Integer, List<Integer>> g = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int[] edge : edges) {
            g.putIfAbsent(edge[0], new ArrayList<>());
            g.putIfAbsent(edge[1], new ArrayList<>());
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1)
                leaves.offer(i);
        }

        while (n > 2) {
            int size = leaves.size();
            n -= size;
            // remove all leafves at one level
            for (int i = 0; i < size; i++) {
                int currLeaf = leaves.poll();
                if (g.containsKey(currLeaf)) {
                    for (int connectedNode : g.get(currLeaf)) {
                        if (--degree[connectedNode] == 1) {
                            leaves.offer(connectedNode);
                        }
                    }
                }
            }
        }

        while (!leaves.isEmpty()) {
            answer.add(leaves.poll());
        }
        return answer;
    }
}