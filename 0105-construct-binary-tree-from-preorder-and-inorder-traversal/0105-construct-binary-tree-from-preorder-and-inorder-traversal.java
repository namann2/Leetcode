class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        int[] preIndex = {0};
        int n = inorder.length;
        for(int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return constructTree(preorder, inorderMap, preIndex, 0, n-1);
    }

    /* helper function */
    private TreeNode constructTree(int[] preorder, Map<Integer, Integer> inorderMap, int[] preIndex, int left, int right) {
        // base case
        if(left > right) {
            return null;
        }
        // main logic
        TreeNode root = new TreeNode(preorder[preIndex[0]]);
        int index = inorderMap.get(preorder[preIndex[0]++]);

        root.left = constructTree(preorder, inorderMap, preIndex, left, index - 1);
        root.right = constructTree(preorder, inorderMap, preIndex, index + 1, right);

        return root;
    }
}