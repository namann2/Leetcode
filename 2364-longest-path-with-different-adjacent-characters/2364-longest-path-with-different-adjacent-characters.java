class Solution {
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < n; i++) {
            g.putIfAbsent(parent[i], new ArrayList<>());
            g.get(parent[i]).add(i);
        }
        return getLongestPath(g, 0, s)[1];
    }

    private int[] getLongestPath(Map<Integer, List<Integer>> g, int root, String s) {
        if(g.containsKey(root)) {
            int firstMax = 0, secondMax = 0, longest = 0;
            for(int child : g.get(root)) {
                int[] childLongestPath = getLongestPath(g, child, s);
                longest = Math.max(longest, childLongestPath[1]);
                // consider all options with current node
                if(s.charAt(root) == s.charAt(child)) continue;
                if(firstMax < childLongestPath[0]) {
                    secondMax = firstMax;
                    firstMax = childLongestPath[0];
                } else if(secondMax < childLongestPath[0]) {
                    secondMax = childLongestPath[0];
                }
            }
            longest = Math.max(longest, 1 + firstMax + secondMax);
            return new int[]{1 + firstMax, longest};
        }
        return new int[]{1, 1}; // leaf node
    }
}