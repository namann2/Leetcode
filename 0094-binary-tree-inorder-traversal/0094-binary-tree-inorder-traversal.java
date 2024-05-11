class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        TreeNode curr = root;
        
        while(curr != null) {
            if(curr.left != null) {
                TreeNode ptr = curr.left;
                while(ptr.right != null && ptr.right != curr) ptr = ptr.right;
                if(ptr.right == null) {
                    ptr.right = curr;
                    curr = curr.left;
                } else {
                    ptr.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            } else {
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans;
    }
}