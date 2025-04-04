class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        // level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(curr.left == null && curr.right == null) return level;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            level++;
        }
        return level;
    }
}