class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()) {
            int prev = -1;
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                if(i == 0) {
                    prev = curr.val;
                    if(level % 2 == 0 && curr.val % 2 != 1) return false;
                    else if(level % 2 == 1 && curr.val % 2 != 0) return false;
                } 
                else {
                    // even level : 
                    if(level % 2 == 0) {
                        if(curr.val % 2 != 1 || curr.val <= prev) return false;
                    } else { // odd level
                        if(curr.val % 2 != 0 || curr.val >= prev) return false;
                    }
                    prev = curr.val;
                }
                // add child nodes
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            level++;
        }
        return true;
    }
}