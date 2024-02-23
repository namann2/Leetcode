Iterative Approach :
```
/**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode() {}
*     TreeNode(int val) { this.val = val; }
*     TreeNode(int val, TreeNode left, TreeNode right) {
*         this.val = val;
*         this.left = left;
*         this.right = right;
*     }
* }
*/
class Solution {
public boolean isValidBST(TreeNode root) {
// iterative approach - Inorder traversal
// the readon we used - Double.MAX_VALUE as min value because someone created
// edge case for Integer that's it
double min = - Double.MAX_VALUE;
return validate(root, min);
}