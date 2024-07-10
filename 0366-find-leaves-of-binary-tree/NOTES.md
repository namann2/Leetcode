​https://leetcode.com/problems/find-leaves-of-binary-tree/discuss/1658659/Great-Question-or-Java-or-Thought-Process <br>

Kandi approach : <br>
https://leetcode.com/problems/find-leaves-of-binary-tree/discuss/83778/10-lines-simple-Java-solution-using-recursion-with-explanation

<br>
More Mind-Fuck approach : Use topological sort -_- <br>

<br>

```
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        TreeNode orgRoot = root;
        
        while(root.left!=null || root.right!=null) {
            List<Integer> t = new ArrayList<>();
            preorder(root, t);
            result.add(t);
        }
        result.add(List.of(orgRoot.val));
        return result;
    }
    private TreeNode preorder(TreeNode node, List<Integer> t) {
        if(node == null) return null;
        if(node.left == null && node.right == null) {
            t.add(node.val);
            return null;
        }
        node.left = preorder(node.left, t);
        node.right = preorder(node.right, t);
        
        return node;
    } 
}
```

***

# Solution. 2: 

```
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        findHeight(root, result);
        return result;
    }
    private int findHeight(TreeNode root, List<List<Integer>> result) {
        if(root == null)
            return 0;
        
        int left = findHeight(root.left, result);
        int right = findHeight(root.right, result);
        
        int currNodeHeight = 1 + Math.max(left, right);
        
        if(result.size() < currNodeHeight)
            result.add(new ArrayList<Integer>());
        
        result.get(currNodeHeight-1).add(root.val);
        
        return currNodeHeight;
    }
}
```
