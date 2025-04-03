## Recurive : 
```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;
        inorderTraversal(root, answer);
        return answer;
    }

    /* helper function */
    private void inorderTraversal(TreeNode root, List<Integer> answer) {
        if(root == null) return;
        inorderTraversal(root.left, answer);
        answer.add(root.val);
        inorderTraversal(root.right, answer);
    }
}
```

## Iterative : 
1. Stack
2. Morris Traversal

### Stack : 
```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {
            // go to leftmost subnode of the curr node
            while(curr != null) {
                stack.addLast(curr);
                curr = curr.left;
            }
            curr = stack.removeLast();
            answer.add(curr.val);
            // explore the right subtree of the curr node
            curr = curr.right;
        }

        return answer;
    }
}
```

### Morris Traversal :

- TC : O(n), every node is visited once <br>
- SC : O(1), since using only constant variables <br>

If we take a closer look, we can notice that every edge of the tree is traversed at most three times. <br>

How 3 ? One while creating the links, Second while actually iterating over the node and third, while removing the link <br>


<hr>
At any given node, we will try to create a thread. If the thread already exists, then we've already a thread TO the current node. Hence, now we need to delete it and go explore the right subtree.

<hr>
<br>

```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null)
            return answer;

        TreeNode curr = root;

        while(curr != null) {
            if(curr.left != null) {
                // 1. constructing the thread
                TreeNode runner = curr.left;
                while(runner != null && runner.right != null && runner.right != curr) {
                    runner = runner.right;
                }
                if(runner.right == null) {
                    runner.right = curr;
                    curr = curr.left;
                } else { // threaded path is already there from runner, hence, we need to break it
                    answer.add(curr.val);
                    curr = curr.right;
                    runner.right = null;
                }
            } else {
                answer.add(curr.val);
                curr = curr.right;
            }
        }
        return answer;
    }
}
```
