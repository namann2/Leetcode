class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return findSum(root, 0);
    }
    private int findSum(TreeNode root, int p) {
        if(root == null) 
            return 0;
        if(root.left == null && root.right == null) {
            int sum = p*10 + root.val;
            return sum;
        }
        
        int left = findSum(root.left, p*10 + root.val);
        int right = findSum(root.right, p*10 + root.val);
        
        return left + right;
    }
}