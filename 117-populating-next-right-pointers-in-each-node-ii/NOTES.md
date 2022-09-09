# Solution 1 :  
```
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            for(int i=0;i<size;i++) {
                Node curr = q.poll();
                curr.next = prev;
                prev = curr;
                
                if(curr.right != null) q.add(curr.right);
                if(curr.left != null) q.add(curr.left);
            }
        }
        
        return root;
    }
}
```


 **** 
 
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


# Solution  3 : 
```
class Solution {
    public Node connect(Node root) {
        Node dummyHead = new Node(-1),
        orgRoot = root,
        prev = dummyHead;
        
        while(root != null) {
            if(root.left != null) {
                prev.next = root.left;
                prev = prev.next;
            }
            if(root.right != null) {
                prev.next = root.right;
                prev = prev.next;
            }
            root = root.next;
            if(root == null) { // current level is done
                prev = dummyHead;
                root = dummyHead.next;
                prev.next = null;
            }
        }
        return orgRoot;
    }
}
```
