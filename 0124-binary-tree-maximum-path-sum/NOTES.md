```
class Solution {
int globalMax;
public int maxPathSum(TreeNode root) {
globalMax = Integer.MIN_VALUE;
if(root == null) return 0;
findMaxPath(root);
return globalMax;
}
private int findMaxPath(TreeNode root) {
if(root == null) return 0;
int leftSubMax = Math.max(0, findMaxPath(root.left));
int rightSubMax = Math.max(0, findMaxPath(root.right));
// if we consider the current node as the root, does the max path passes through it ?
globalMax = Math.max(globalMax, root.val + leftSubMax + rightSubMax); // check if current path is the max
return root.val + Math.max(leftSubMax, rightSubMax); // return max path in the subtree
}
}
```