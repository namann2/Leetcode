class Solution {
    public TreeNode balanceBST(TreeNode root) {
        if(root == null) return null;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return constructBST(list, 0, list.size()-1);
    }
    private void inorder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    private TreeNode constructBST(List<Integer> list, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) >> 1;
        TreeNode newNode = new TreeNode(list.get(mid));
        newNode.left = constructBST(list, start, mid - 1);
        newNode.right = constructBST(list, mid + 1, end);
        return newNode;
    }
}