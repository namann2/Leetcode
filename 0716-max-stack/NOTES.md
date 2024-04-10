We can do this similar to the approach that we used in LRU cache.
Maintain DLL, Map< Integer, List < Node > > , PQ and update these for every operation

Following is the chart of operations that are performed : 

| Operation | DLL  | Map  | PQ      |
|-----------|------|------|---------|
| push      | O(1) | O(1) | O(log N)|
| pop       | O(1) | O(1) | O(log N)|
| top       | O(1) | X    | X       |
| maxPeek   | X    | X    | O(log N)|
| maxPop    | O(1) | O(1) | O(log N)|



```
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
    }
}
class MaxStack {

    private Node dH, dT;
    private Map<Integer, List<Node>> map;
    private PriorityQueue<Integer> pq;
    private int size;
    public MaxStack() {
        dH = new Node(-1);
        dT = new Node(-1);
        dH.next = dT;
        dT.prev = dH;
        map = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        size = 0;
    }
    
    public void push(int x) {
        // DLL
        Node newNode = new Node(x);
        newNode.next = dH.next;
        dH.next.prev = newNode;
        dH.next = newNode;
        newNode.prev = dH;
        // Map
        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(newNode);
        // pq
        pq.offer(x);
    }
    
    public int pop() {
        Node nodeToRemove = dH.next;
        int val = nodeToRemove.data;
        // DLL
        dH.next = dH.next.next;
        dH.next.prev = dH;
        // Map
        List<Node> l = map.get(val);
        l.remove(l.size()-1);
        if(l.size() > 0)
            map.put(val, l);
        // pq
        pq.remove(val);
        return val;
    }
    
    public int top() {
        return dH.next.data;
    }
    
    public int peekMax() {
        return pq.peek();
    }
    
    public int popMax() {
        // pq
        int x = pq.poll();
        // map
        List<Node> l = map.get(x);
        Node node = l.get(l.size()-1);
        l.remove(l.size()-1);
        // DLL
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return x;
    }
}
```
