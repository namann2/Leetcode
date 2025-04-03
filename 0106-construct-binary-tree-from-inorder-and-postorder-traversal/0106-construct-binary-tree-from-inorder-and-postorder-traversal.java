class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        int n = postorder.length;
        int[] postIndex = {n-1};
        for(int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return constructTree(postorder, inorderMap, postIndex, 0, n-1);
    }

    /* helper function */
    private TreeNode constructTree(int[] postorder, Map<Integer, Integer> inorderMap, int[] postIndex, int left, int right) {
        // base case
        if(left > right) {
            return null;
        }
        // main logic
        TreeNode root = new TreeNode(postorder[postIndex[0]]);
        int index = inorderMap.get(postorder[postIndex[0]--]);

        root.right = constructTree(postorder, inorderMap, postIndex, index + 1, right);
        root.left = constructTree(postorder, inorderMap, postIndex, left, index - 1);
        
        return root;
    }
}