class Node {
    int key;
    Node prev, next;
    Node(int key) {
        this.key = key;
    }
}
class MaxStack {

    private Map<Integer, List<Node>> map;
    private Node dH, dT;
    private PriorityQueue<Integer>maxHeap;
    
    public MaxStack() {
        map = new HashMap<>();
        dH = new Node(-1);
        dT = new Node(-1);
        dH.next = dT;
        dT.prev = dH;
        maxHeap = new PriorityQueue<>((a, b) -> b-a);
    }

    public void push(int x) {
        Node newNode = new Node(x);
        
        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(newNode);
        
        dH.next.prev = newNode;
        newNode.next = dH.next;
        dH.next = newNode;
        newNode.prev = dH;
        
        maxHeap.offer(x);
    }
    
    public int pop() {
        Node node = dH.next;
        dH.next = node.next;
        node.next.prev = dH;
        
        List<Node> cnt = map.get(node.key);
        cnt.remove(cnt.size()-1);
        if(cnt.size() == 0)
            map.remove(node.key);
        else map.put(node.key, cnt);
        
        maxHeap.remove(node.key);
        return node.key;
    }
    
    public int top() {
        return dH.next.key;
    }
    
    public int peekMax() {
        return maxHeap.peek();
    }
    
    public int popMax() {
        int x = maxHeap.poll();
        
        List<Node> allNodes = map.get(x);
        Node lastNode = allNodes.get(allNodes.size() - 1);
        allNodes.remove(allNodes.size()-1);
        
        if(allNodes.size() == 0)
            map.remove(x);
        else map.put(x, allNodes);
        
        lastNode.next.prev = lastNode.prev;
        lastNode.prev.next = lastNode.next;
        
        return x;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */