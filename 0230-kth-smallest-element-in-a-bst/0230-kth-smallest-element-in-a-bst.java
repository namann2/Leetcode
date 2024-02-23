class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // TC : O(N), SC : O(H) 
        // We can use morris traversal to save extra space
        // Stack<TreeNode> stack = new Stack<>();
        // TreeNode curr = root;
        // while(curr != null || !stack.isEmpty()) {
        //     while(curr != null) {
        //         stack.push(curr);
        //         curr = curr.left;
        //     }
        //     curr = stack.pop();
        //     if(--k == 0) return curr.val;
        //     curr = curr.right;
        // }
        // return -1;
        
        // Morris Inorder Traversal : TC : O(3N), SC : O(1)

        // Check Notes for follow-up question
        
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left != null) {
                // update the thread from leaf to curr
                TreeNode ptr = curr.left;
                while(ptr.right != null && ptr.right != curr) 
                    ptr = ptr.right;
                // two conditions for the ptr
                if(ptr.right == null) {
                    ptr.right = curr;
                    curr = curr.left;
                } else { // ptr.right points to the curr
                    ptr.right = null;
                    if(--k == 0) return curr.val;
                    curr = curr.right;
                }
                
            } else {
                if(--k == 0) return curr.val;
                curr = curr.right;
            }
        }
        return -1;
    }
}
