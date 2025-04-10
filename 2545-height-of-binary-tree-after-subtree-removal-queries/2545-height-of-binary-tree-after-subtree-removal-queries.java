class NodeHeightPair {
    TreeNode node;
    int height;

    public NodeHeightPair(TreeNode node, int height) {
        this.node = node;
        this.height = height;
    }
}

class Solution {

    Map<Integer, Integer> nodeLevel;
    Map<Integer, Integer> nodeHeight;
    Map<Integer, PriorityQueue<NodeHeightPair>> levelTwoMaxHeight;

    public int[] treeQueries(TreeNode root, int[] queries) {
        
        if(root == null) return new int[]{};

        nodeLevel = new HashMap<>();
        nodeHeight = new HashMap<>();
        levelTwoMaxHeight = new HashMap<>();

        iterate(root, 0);
        return performSubQueries(queries);
    }

    /* helper functions */
    private int iterate(TreeNode root, int depth) {
        if(root == null) return -1;
        
        // update currNode Level
        nodeLevel.put(root.val, depth);

        int left = iterate(root.left, depth + 1);
        int right = iterate(root.right, depth + 1);

        // update currNode height
        int currNodeHeight = 1 + Math.max(left, right);
        nodeHeight.put(root.val, currNodeHeight);

        // update two max height at the same level
        levelTwoMaxHeight.putIfAbsent(depth, new PriorityQueue<>((p,q) -> {
            return p.height - q.height;
        }));

        levelTwoMaxHeight.get(depth).offer(new NodeHeightPair(root, currNodeHeight));
        if(levelTwoMaxHeight.get(depth).size() > 2) 
            levelTwoMaxHeight.get(depth).remove();

        return currNodeHeight;
    }

    private int[] performSubQueries(int[] queries) {
        int qLength = queries.length;
        int[] answer = new int[qLength];

        for(int i = 0; i < qLength; i++) {
            int nodeToRemove = queries[i];
            int depth = nodeLevel.get(nodeToRemove);
            int height = nodeHeight.get(nodeToRemove);

            if(levelTwoMaxHeight.get(depth).size() == 1) {
                answer[i] = depth - 1;
            } else {
                NodeHeightPair secondMax = levelTwoMaxHeight.get(depth).remove();
                NodeHeightPair firstMax = levelTwoMaxHeight.get(depth).remove();

                if(firstMax.node.val != nodeToRemove) answer[i] = firstMax.height + depth;
                else if(secondMax.node.val != nodeToRemove) answer[i] = secondMax.height + depth;
                else answer[i] = depth - 1;

                levelTwoMaxHeight.get(depth).offer(secondMax);
                levelTwoMaxHeight.get(depth).offer(firstMax);
            }
        }
        return answer;
    }
}