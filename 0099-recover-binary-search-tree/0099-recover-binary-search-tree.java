class Solution {
    public void recoverTree(TreeNode root) {
        // Morris Traversal
        TreeNode curr = root;
        TreeNode prev = null, first = null, second = null;
        while(curr != null) {
            if(curr.left != null) {
                TreeNode ptr = curr.left;
                while(ptr.right != null && ptr.right != curr) 
                    ptr = ptr.right;
                if(ptr.right == null) {
                    ptr.right = curr;
                    curr = curr.left;
                } else {
                    ptr.right = null;
                    if(prev != null) {
                        if(prev.val > curr.val && first == null) first = prev;
                        if(prev.val > curr.val && first != null) second = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            } else {
                if(prev != null) {
                    if(prev.val > curr.val && first == null) first = prev;
                    if(prev.val > curr.val && first != null) second = curr;
                }
                prev = curr;
                curr = curr.right;
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}