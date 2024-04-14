```
class Solution {
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
if(root == null) return null;
int[] count = {0};
TreeNode lca = LCA(root, p, q, count);
return count[0] == 2 ? lca : null;
}
private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q, int count[]) {
if(root == null) return null;
TreeNode left = LCA(root.left, p, q, count);
TreeNode right = LCA(root.right, p, q, count);
if(root.val==p.val || root.val==q.val) {
count[0]++;
return root;
}
if(left!=null && right!=null) return root;
return left == null ? right : left;
}
}
```