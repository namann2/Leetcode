Given :
1. The structure of the tree is such that the current node contains the min from its subtree.
2. A node has either 0 or 2 children.
3. We need to find the second minimum. Logically thinking, we will get the second min from that path/direction(left or right) of the subtree for which current root's value is equal to the child val.
​
image by [416486188](https://leetcode.com/416486188/)
​
![image](https://assets.leetcode.com/users/images/e1f159b1-3eb7-489b-b80c-6f7db84a51f8_1653197520.109165.png)
​
​
If for a node, the child value is not equal to the current node's value, then we can say that this child could be the second minimum ( based on rule 1)
​
Code :
​
```
class Solution {
public int findSecondMinimumValue(TreeNode root) {
if(root == null)
return -1;
if(root.left == null && root.right == null)
return -1;