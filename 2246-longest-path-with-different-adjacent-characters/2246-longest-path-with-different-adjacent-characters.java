class Solution {
    int longestPath = 0;
    public int longestPath(int[] parent, String s) {
        longestPath = 1; // default root node
        Map<Integer, List<Integer>> g = new HashMap<>();
        int n = s.length();
        for(int i = 1; i < n; i++) {
            g.putIfAbsent(parent[i], new ArrayList<>());
            g.get(parent[i]).add(i);
        }
        traverse(0, s, parent, g);
        return longestPath;
    }
    
    private int traverse(int curr, String s, int[] parent, Map<Integer, List<Integer>> g) {
        if(g.containsKey(curr)) {
            List<int[]> maxValues = new ArrayList<>(); 
            int firstMax = 0, secondMax = 0;
            for(int child : g.get(curr)) {
                int pathLengthFromCurrentNode = traverse(child, s, parent, g);
                if(s.charAt(child) != s.charAt(curr)) {
                    if(pathLengthFromCurrentNode > firstMax) {
                        secondMax = firstMax;
                        firstMax = pathLengthFromCurrentNode;
                    } else if(pathLengthFromCurrentNode > secondMax) {
                        secondMax = pathLengthFromCurrentNode;
                    }
                }
            }
            // longestPath = Math.max(longestPath, Math.max(firstMax + 1, firstMax + secondMax + 1));
            longestPath = Math.max(longestPath, firstMax + secondMax + 1);
            return firstMax + 1;
        }
        return 1;
    }
}