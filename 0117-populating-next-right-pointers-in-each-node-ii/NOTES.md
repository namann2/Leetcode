# Solution 1 : Level Order Traversal

`TC : O(n)` <br>
`SC : O(n)`

Keep the "next i.e. dummy node" node on the right side and connect right nodes first.

```
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            Node next = null;
            for(int i=0;i<size;i++) {
                Node curr = q.poll();
                curr.next = next;
                next = curr;
                
                if(curr.right != null) q.add(curr.right);
                if(curr.left != null) q.add(curr.left);
            }
        }
        
        return root;
    }
}
```

 ***
 
# Solution 2:
```
class Solution {
    public Node connect(Node root) {

        if(root == null) return null;
        
        if(root.left != null) 
            root.left.next = root.right != null ? root.right : findNext(root.next);
        
        if(root.right != null) 
            root.right.next = findNext(root.next);
        
        connect(root.right);
        connect(root.left);
        
        return root;
    }
    
    private Node findNext(Node node) {
        if(node == null) return null;
        
        if(node.left!=null) return node.left;
        if(node.right!=null) return node.right;
        
        return findNext(node.next);
    }
}
```


# Solution  3 : Using previously established next pointers

`TC : O(n)` <br>
`SC : O(1)`

Keeping the dummy node on left and connecting next pointers from left to right i.e left nodes and then right nodes
[ This logic is built on top of Solution 1 ]

We have to process all the nodes of the tree. So we can't reduce the time complexity any further. 
However, we can try and reduce the space complexity. 
The reason we need a queue here is because we don't have any idea about the structure of the tree and the kind of branches it has and we need to access all the nodes on a common level, together, and establish connections between them. Hence, we need to traverse the tree

- top down manner
- work on each level nodes

Once we are done establishing the next pointers between the nodes, don't they kind of represent a linked list? 🤔
After the next connections are established, all the nodes on a particular level actually form a `linked list` via these next pointers. Based on this idea, we have the following intuition for our space efficient algorithm. At this point, it should be clear that the nodes at a particular level can be iterated either `left to right` or `right to left`.

<br>
<br>
TODO : Ponder over the direction from right to left. Here, I am going ahead with left to right.
<br>
<br>
Since we are talking about going level by level, we need to work upon each node(/s) on that particular level. Essentially speaking, for a level we are at, pick nodes from left to right and keep updating the next pointers of node in the child level. Once all the nodes on particular level are done, our pointer will point to null indicating the current level is completed and we need to move to the next level.
<br>
<br>

```
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        
        Node originalRoot = root;
        Node dNode = new Node(-101);
        Node prev = dNode;
        
        while(root != null) {
            // pick a node, work on updating the next pointers for the child nodes
            if(root.left != null) {
                prev.next = root.left;
                prev = prev.next;
            }
            if(root.right != null) {
                prev.next = root.right;
                prev = root.right;
            }
            // go to the next node in the current level
            root = root.next;
            // if all nodes in the current level are done, our pointer would point to null -> indicating we need to move to next level
            if(root == null) {
                root = dNode.next;
                dNode.next = null;
                prev = dNode;
            }
        }
        
        return originalRoot;
    }
}
```
