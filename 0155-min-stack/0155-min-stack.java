class Node {
    int data, min;
    Node next;
    
    Node(int data, int min, Node next) {
        this.data = data;
        this.min = min;
        this.next = next;
    }
}

class MinStack {

    Node head;
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if(head == null) {
            head = new Node(val, val, null);
        } else {
            Node newNode = new Node(val, Math.min(val, head.min), head);
            head = newNode;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
}