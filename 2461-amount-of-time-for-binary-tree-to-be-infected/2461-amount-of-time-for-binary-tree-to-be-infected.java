class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        dfs(root, parent);

        for(TreeNode node : parent.keySet()) {
            if(node.val == start) {
                return bfs(parent, node);
            }
        }
        return -1;
    }

    /* helper function */
    private void dfs(TreeNode root, Map<TreeNode, TreeNode> parent) {
        // base case
        if(root == null || isLeaf(root)) return;
        // main logic
        if(root.left != null) parent.put(root.left, root);
        if(root.right != null) parent.put(root.right, root);

        dfs(root.left, parent);
        dfs(root.right, parent);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private int bfs(Map<TreeNode, TreeNode> parent, TreeNode startNode) {
        Set<TreeNode> visited = new HashSet<>();
        int timeTaken = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(startNode);
        visited.add(startNode);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();
                TreeNode currNodeParent = parent.get(currNode);
                if(currNodeParent != null && visited.add(currNodeParent)) q.offer(currNodeParent);
                if(currNode.left != null && visited.add(currNode.left)) q.offer(currNode.left);
                if(currNode.right != null && visited.add(currNode.right)) q.offer(currNode.right);
            }
            timeTaken++;
        }
        return timeTaken - 1; // for the last level we do not need more time
    }
}