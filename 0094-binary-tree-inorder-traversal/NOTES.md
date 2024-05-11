TC : O(n), every node is visited once
SC : O(1), if recursive stack space not included else, O(h), where h is the height of the tree
​
​
### Morris Traversal :
​
Time Complexity: O(n)
If we take a closer look, we can notice that every edge of the tree is traversed at most three times.
How 3 ? One while creating the links, Second while actually iterating over the node and third, while removing the link
Auxiliary Space: O(1) since using only constant variables
```
class Solution {
public List<Integer> inorderTraversal(TreeNode root) {
List<Integer> ans = new ArrayList<>();
if(root == null) return ans;
TreeNode curr = root;
while(curr != null) {
if(curr.left != null) {
TreeNode ptr = curr.left;