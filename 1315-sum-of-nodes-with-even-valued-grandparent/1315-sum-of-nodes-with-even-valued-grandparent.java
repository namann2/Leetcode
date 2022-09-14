class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return 0;
        
        return sum(root, -1, -1);
    }
    private int sum(TreeNode root, int parent, int grand) {
        if(root == null) 
            return 0;
        
        int sum = 0;
        
        if(grand % 2 == 0) 
            sum += root.val;
        
        int left = sum(root.left, root.val, parent);
        int right = sum(root.right, root.val, parent);
        
        return sum + left + right;
    }
}