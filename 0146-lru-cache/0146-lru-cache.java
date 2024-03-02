class Node {
    int key, val;
    Node prev, next;
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    
    private Node dH, dT;
    private HashMap<Integer, Node> map;
    private int max_capacity;
    
    public LRUCache(int capacity) {
        this.dH = new Node(-1,-1);
        this.dT = new Node(-1,-1);
        dH.next = dT;
        dT.prev = dH;
        this.max_capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
            remove(map.get(key));
        
        if(map.size() >= this.max_capacity) {
            remove(dT.prev);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
    }
    
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insert(Node node) {
        map.put(node.key, node);
        Node next = dH.next;
        dH.next = node;
        next.prev = node;
        node.prev = dH;
        node.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
