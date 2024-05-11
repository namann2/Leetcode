class Solution {
    public Node treeToDoublyList(Node root) {
//         if(root == null) return null;
//         Node prev = null, curr = root, head = null;
//         Stack<Node> stack = new Stack<>();
        
//         while(!stack.isEmpty() || curr != null) {
//             while(curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             }
            
//             curr = stack.pop();
//             if(prev == null) {
//                 prev = curr;
//                 head = curr;
//             } else {
//                 prev.right = curr;
//                 curr.left = prev;
//                 prev = curr;
//             }
//             curr = curr.right;
//         }
        
//         prev.right = head;
//         head.left = prev;
//         return head;
        
        if(root == null) return null;
        
        Node prev = null, head = null, curr = root;
        
        while(curr != null) {
            if(curr.left != null) {
                Node ptr = curr.left;
                while(ptr.right != null && ptr.right != curr) ptr = ptr.right;
                if(ptr.right == null) {
                    ptr.right = curr;
                    curr = curr.left;
                } else {
                    ptr.right = null;
                    if(prev == null) {
                        prev = curr;
                        head = curr;
                    } else {
                        prev.right = curr;
                        curr.left = prev;
                        prev = curr;
                    }
                    curr = curr.right;
                }
            } else {
                if(prev == null) {
                    prev = curr;
                    head = curr;
                } else {
                    prev.right = curr;
                    curr.left = prev;
                    prev = curr;
                }
                curr = curr.right;
            }
        }
        prev.right = head;
        head.left = prev;
        return head;
    }
}