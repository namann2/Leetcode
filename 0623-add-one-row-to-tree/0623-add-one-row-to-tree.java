class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int d) {
        d --;
        if(d == 0) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(--d > 0) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
        }
        
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            // old links
            TreeNode currLeft = curr.left;
            TreeNode currRight = curr.right;
            
            // new
            TreeNode newLeftNode = new TreeNode(val);
            TreeNode newRightNode = new TreeNode(val);
            
            curr.left = newLeftNode;
            curr.right = newRightNode;
            
            newLeftNode.left = currLeft;
            newRightNode.right = currRight;
        }
        return root;
    }
}