class Solution {
    public Node connect(Node root) {
        if(root == null) 
            return null;
        
        Node dH = new Node(-1);
        Node orgRoot = root;
        Node ptr = dH;
        
        while(root != null) {
            
            if(root.left != null) {
                ptr.next = root.left;
                ptr = ptr.next;
            }
            
            if(root.right != null) {
                ptr.next = root.right;
                ptr = ptr.next;
            }
            
            root = root.next;
            
            if(root == null) {
                root = dH.next;
                ptr = dH;
                dH.next = null;
            }
        }
        
        return orgRoot;
    }
}