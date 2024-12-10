class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        int n = inorder.length;
        int[] preIndex = {0};
        for(int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return construct(preorder, inorderMap, 0, n-1, preIndex);
    }
    
    private TreeNode construct(int[] preorder, Map<Integer, Integer> inorderMap, int left, int right, int[] preIndex) {
        // base case
        if(left > right) {
            return null;
        }
        // main case
        TreeNode root = new TreeNode(preorder[preIndex[0]++]);
        int inIndex = inorderMap.get(root.val);
        root.left = construct(preorder, inorderMap, left, inIndex - 1, preIndex);
        root.right = construct(preorder, inorderMap, inIndex + 1, right, preIndex);
        return root;
    }
}