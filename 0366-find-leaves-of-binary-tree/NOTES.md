​https://leetcode.com/problems/find-leaves-of-binary-tree/discuss/1658659/Great-Question-or-Java-or-Thought-Process <br>

Kandi approach : <br>
https://leetcode.com/problems/find-leaves-of-binary-tree/discuss/83778/10-lines-simple-Java-solution-using-recursion-with-explanation

<br>
More Mind-Fuck approach : Use topological sort -_- <br>

In the other approaches, we are actually updating the links of node with its parent, but see the below question : <br>
This is actually a question from Google : <br>
<br>
Q. Given a tree, you need to select a leaf and remove it, and repeat this process until all the nodes are removed. <br>
Return the removal sequence. You don’t need to mutate the tree by cutting edges to remove nodes. <br>
Also, if a leaf is removed and its parent becomes a new leaf, then the new leaf must be removed before all other current leaves. <br>

            1
        2       4
    3
    
required ans : [3, 2, 4, 1]<br>

```
class Solution {
    public List<Integer> findLeaves(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null)
            return answer;
        
        List<Integer> A = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Map<TreeNode, Integer> indegree = new HashMap<>();
        
        traversal(root, parent, indegree);
        
        Deque<TreeNode> q = new ArrayDeque<>();
        for(TreeNode node : indegree.keySet()) {
            if(indegree.get(node) == 0)
                q.offer(node);
        }
        
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            A.add(curr.val);
            TreeNode parentNode = parent.get(curr);
            if(parentNode != null) {
                indegree.put(parentNode, indegree.get(parentNode) - 1);
                // add first because we need to remove the parent which became a leaf before removing any other node 
                if(indegree.get(parentNode) == 0) 
                    q.addFirst(parentNode);
            }
        }
        
        return answer;
    }
    
    private void traversal(TreeNode node, Map<TreeNode, TreeNode> parent, Map<TreeNode, Integer> indegree) {
        if(node == null) return;
        
        if(node.left == null && node.right == null) {
            indegree.put(node, 0);
            return;
        }
        
        if(node.left != null) {
            indegree.put(node, indegree.getOrDefault(node, 0) + 1);
            parent.put(node.left, node);
        }
        if(node.right != null) {
            indegree.put(node, indegree.getOrDefault(node, 0) + 1);
            parent.put(node.right, node);
        }
        
        traversal(node.left, parent, indegree);
        traversal(node.right, parent, indegree);
    }
}

```

Leetcode question solution : <br>
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
