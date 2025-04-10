/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if(root == null) return null;
        Set<Integer> allNodesForLCA = new HashSet<>();
        for(TreeNode node : nodes) allNodesForLCA.add(node.val);
        return LCA(root, allNodesForLCA);
    }

    private TreeNode LCA(TreeNode root, Set<Integer> allNodes) {
        if(root == null) return null;
        if(allNodes.contains(root.val)) {
            return root;
        }

        TreeNode left = LCA(root.left, allNodes);
        TreeNode right = LCA(root.right, allNodes);

        if(left != null && right != null) return root;
        return left == null ? right : left;
    }
}