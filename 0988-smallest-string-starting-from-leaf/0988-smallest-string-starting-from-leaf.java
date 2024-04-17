class Solution {
    String smallestString = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return smallestString;
    }

    void dfs(TreeNode root, String currentString) {

        if (root == null) return;
        currentString = (char) (root.val + 'a') + currentString;

        if (root.left == null && root.right == null) {
            if (smallestString.isEmpty() || smallestString.compareTo(currentString) > 0) {
                smallestString = currentString;
            }
        }

        if (root.left != null) {
            dfs(root.left, currentString);
        } 

        if (root.right != null) {
            dfs(root.right, currentString);
        }

    }
}