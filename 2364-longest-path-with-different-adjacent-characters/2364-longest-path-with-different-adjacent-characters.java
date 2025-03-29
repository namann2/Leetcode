class Solution {
    int longest = 1;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        Map<Integer, List<Integer>> g = new HashMap<>();
        int root = 0;
        for(int i = 0; i < n; i++) {
            g.putIfAbsent(parent[i], new ArrayList<>());
            g.get(parent[i]).add(i);
        }
        dfs(g, root, s);
        return longest;
    }

    private int dfs(Map<Integer, List<Integer>> g, int root, String s) {
        // base case
        if(!g.containsKey(root)) { // curr node is a leaf node
            return 1;
        }
        // main logic
        int firstMax = 0, secondMax = 0;
        for(int child : g.get(root)) {
            int childPathLength = dfs(g, child, s);
            if(s.charAt(root) == s.charAt(child)) continue;
            if(childPathLength > firstMax) {
                secondMax = firstMax;
                firstMax = childPathLength;
            } else if(childPathLength > secondMax) {
                secondMax = childPathLength;
            }
            longest = Math.max(longest, 1 + firstMax + secondMax);
        }
        return 1 + firstMax;
    }
}