class LRUCache {

    private Map<Integer, Node> map;
    private Node dH,dT;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.dH = new Node(-1, -1);
        this.dT = new Node(-1, -1);
        dH.next = dT;
        dT.prev = dH;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.data;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
            remove(map.get(key));
        if(map.size() >= capacity) 
            remove(dT.prev);
        Node node = new Node(key, value);
        insert(node);
    }
    
    private void insert(Node node) {
        map.put(node.key, node);
        
        Node tmp = dH.next;
        dH.next = node;
        node.prev = dH;
        
        node.next = tmp;
        tmp.prev = node;
    }
    
    private void remove(Node node) {
        map.remove(node.key);
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    int key, data;
    Node prev, next;
    Node(int key, int data) {
        this.key = key;
        this.data = data;
    }
}
