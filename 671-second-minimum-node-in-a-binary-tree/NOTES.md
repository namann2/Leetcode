# Pointers : 
1. The structure of the tree is such that the current node contains the min from its subtree. 
2. A node has either 0 or 2 children.
3. We need to find the second minimum. Logically thinking, we will get the second min from that path/direction(left or right) of the subtree for which current root's value is equal to the child val.
4. The first node that is not equal to the first min ( aka root ) would be our answer. For a node, we will have to go to the left subtree and right subtree and find the min out of it.

image by [416486188](https://leetcode.com/416486188/)

![image](https://assets.leetcode.com/users/images/e1f159b1-3eb7-489b-b80c-6f7db84a51f8_1653197520.109165.png)


If for a node, the child value is not equal to the current node's value, then we can say that this child could be the second minimum ( based on rule 1)

# Naive Code : Yuck

```
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) 
            return -1;
        if(root.left == null && root.right == null)
            return -1;
        
        return findMinimum(root, root.val);
    }
    private int findMinimum(TreeNode root, int val) {
        // base case
        if(root == null) 
            return -1;
        
        if(root.val > val)
            return root.val;
        
        int left = (root.left!=null && root.left.val == root.val) ? findMinimum(root.left, root.val) : (root.left == null ? -1 : root.left.val);
        int right = (root.right!=null && root.right.val == root.val) ? findMinimum(root.right, root.val) : (root.right == null ? -1 : root.right.val);
        
        if(left != -1 && right != -1)
            return Math.min(left, right);
        else if(left == -1) return right;
        return left;
    }
}
```

TC : `O(n)`
SC : `O(n)`


# Optimal Code : ( Clean Code )

```
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        // TC : O(N), SC : O(H)
        if(root == null) return -1;
        return secondMin(root, root.val);
    }
    private int secondMin(TreeNode node, int fm) {
        if(node == null) return -1;
        
        if(node.val > fm) return node.val;
        
        int left = secondMin(node.left, fm);
        int right = secondMin(node.right, fm);
        
        if(left != -1 && right != -1) return Math.min(left, right);
        return left == -1 ? right : left;
    }
}

```
