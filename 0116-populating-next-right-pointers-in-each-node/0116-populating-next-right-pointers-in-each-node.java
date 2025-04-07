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