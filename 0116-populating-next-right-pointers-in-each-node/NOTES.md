​There are two ways to solve this and both are equally important : 

## Approach 1 : DFS

```
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.next != null && root.right != null) root.right.next = root.next.left;
        if(root.left != null) root.left.next = root.right;
        connect(root.left);
        connect(root.right);
        return root;
    }
}
```

## Approach 2 : Level Order 

```
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            Node next = null;
            for(int i = 0; i < size; i++) {
                Node curr = q.poll();
                if(next != null) {
                    curr.next = next;
                }
                next = curr;
                if(curr.right != null) q.offer(curr.right);
                if(curr.left != null) q.offer(curr.left);
            }
        }
        return root;
    }
}
```
