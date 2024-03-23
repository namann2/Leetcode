class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        
        Stack<ListNode> stack = new Stack<>();
        int size = 0;
        ListNode ptr = head;
        while(ptr != null) {
            size++;
            stack.push(ptr);
            ptr = ptr.next;
        }
        
        // insert stack.top in between two nodes of original list
        ListNode L = head;
        for(int i=0;i<size/2;i++) {
            ListNode next = L.next;
            ListNode curr = stack.pop();
            L.next = curr;
            curr.next = next;
            L = next;
        }
        L.next = null;
    }
}
/*
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        reorderList(head, head.next);
    }
    
    public ListNode reorderList(ListNode root, ListNode curr) {
        if (curr == null) return root;

        // keep on passing the intial root to the end
        root = reorderList(root, curr.next);

        if (root == null) return null;
        
//          * we stop reconfiguring in 2 cases. 
//          *   1. returned new root is same as head: Odd number of list 
//                 items so we have come to the middle
//          *   2. returned new root's next is same as head: Even number of list items
         
        ListNode temp = null;
        if (root == curr || root.next == curr) {
            curr.next = null;
        } else {
            // make returned root's next to be curr and return root's next as the new root
            temp = root.next;
            root.next = curr;
            curr.next = temp;
        }
        return temp;
    }
}
*/