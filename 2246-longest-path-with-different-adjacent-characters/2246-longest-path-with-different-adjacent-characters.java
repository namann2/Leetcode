class Solution {
    public int longestPath(int[] parent, String s) {
        int n = s.length();
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 1; i < n; i++) {
            g.putIfAbsent(parent[i], new ArrayList<>());
            g.get(parent[i]).add(i);
        }
        return traverse(g, 0, s)[1];
    }
    
    private int[] traverse(Map<Integer, List<Integer>> g, int root, String s) {
        if(g.containsKey(root)) {
            int firstMax = 0, secondMax = 0, longestPath = 0;
            for(int child : g.get(root)) {
                int[] childValues = traverse(g, child, s);
                int pathLengthFromCurrentNode = childValues[0];
                longestPath = Math.max(longestPath, childValues[1]);
                if(s.charAt(child) == s.charAt(root)) continue;
                if(pathLengthFromCurrentNode > firstMax) {
                    secondMax = firstMax;
                    firstMax = pathLengthFromCurrentNode;
                } else if(pathLengthFromCurrentNode > secondMax) {
                    secondMax = pathLengthFromCurrentNode;
                }
            }
            longestPath = Math.max(longestPath, firstMax + secondMax + 1);
            return new int[]{1 + firstMax, longestPath};
        }
        return new int[]{1,1};
    }
}