/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Follow-up : find the number of turns needed to reach from one node to another
    // https://www.geeksforgeeks.org/number-turns-reach-one-node-binary-tree/
    public String getDirections(TreeNode root, int s, int d) {
        if(root == null) return null;
        TreeNode lca = findLCA(root, s, d);
        StringBuilder ps = new StringBuilder();
        StringBuilder ds = new StringBuilder();
        traverse(lca, s, ps, "U", "U");
        traverse(lca, d, ds, "L", "R");
        return ps.append(ds).toString();
    }
    
    private boolean traverse(TreeNode root, int s, StringBuilder path, String left, String right) {
        if(root == null) return false;
        if(root.val == s) return true;
        
        int n = path.length();
        
        path.append(left);
        if(traverse(root.left, s, path, left, right)) return true;
        path.setLength(n);
        
        path.append(right);
        if(traverse(root.right, s, path, left, right)) return true;
        path.setLength(n);
        
        return false;
    }
    
    private TreeNode findLCA(TreeNode root, int s, int d) {
        if(root == null) return null;
        if(root.val == s || root.val == d) return root;
        
        TreeNode leftSubtree = findLCA(root.left, s, d);
        TreeNode rightSubtree = findLCA(root.right, s, d);
        
        if(leftSubtree != null && rightSubtree != null) return root;
        return leftSubtree != null ? leftSubtree : rightSubtree;
    }
}