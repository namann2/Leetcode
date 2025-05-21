class Solution {
    public int longestPath(int[] parent, String s) {
        int rootNode = -1, n = s.length();
        if(n == 1) return 1;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(parent[i] == -1) rootNode = i;
            else {
                g.putIfAbsent(parent[i], new ArrayList<>());
                g.get(parent[i]).add(i);
            }
        }

        return dfs(g, rootNode, s, n)[0];
    }

    private int[] dfs(Map<Integer, List<Integer>> g, int root, String s, int n) {
        if(g.containsKey(root)) {
            int firstMax = 0, secondMax = 0, longestPath = 1;
            for(int child : g.get(root)) {
                int[] childPathLength = dfs(g, child, s, n);
                // update the longest path uptil now
                longestPath = Math.max(longestPath, childPathLength[0]);
                if(s.charAt(child) == s.charAt(root)) continue;
                // update the firstMax and secondMax
                if(childPathLength[1] > firstMax) {
                    secondMax = firstMax;
                    firstMax = childPathLength[1];
                } else if(childPathLength[1] > secondMax) {
                    secondMax = childPathLength[1];
                }
            }
            longestPath = Math.max(longestPath, 1 + firstMax + secondMax);
            return new int[]{longestPath, firstMax + 1};
        }
        return new int[]{1, 1};
    }
}