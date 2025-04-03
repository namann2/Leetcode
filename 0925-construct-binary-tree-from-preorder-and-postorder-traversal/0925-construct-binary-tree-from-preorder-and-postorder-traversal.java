class Solution {
    int preIndex = 0, postIndex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return constructTree(preorder, postorder);
    }

    /* helper functions */
    private TreeNode constructTree(int[] preorder, int[] postorder) {
        // main logic
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if(root.val != postorder[postIndex]) {
            root.left = constructTree(preorder, postorder);
        }
        if(root.val != postorder[postIndex]) {
            root.right = constructTree(preorder, postorder);
        }
        postIndex++;
        return root;
    }
}