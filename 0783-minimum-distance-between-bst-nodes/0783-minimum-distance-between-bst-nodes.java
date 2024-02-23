class Solution {
    public int minDiffInBST(TreeNode root) {
        /*
            Minimum diff between any two node in a bst can be only 
            found from the adjacent nodes. Doing inorder traversal, we
            will have the sorted format of all numbers, we can then find the 
            difference between them to find the min.
        */
        if(root == null) return 0;
        List<Integer> all = new ArrayList<>();
        inorder(root, all);
        // we now have a sorted sequence of data
        int ans = Integer.MAX_VALUE, size = all.size();
        for(int i=1;i<size;i++) {
            ans = Math.min(ans, all.get(i) - all.get(i-1));
        }
        return ans;
    }
    private void inorder(TreeNode root, List<Integer> all) {
        if(root == null) return;
        inorder(root.left, all);
        all.add(root.val);
        inorder(root.right, all);
    }
}