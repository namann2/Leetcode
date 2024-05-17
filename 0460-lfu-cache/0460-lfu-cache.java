class Node {
    int key, value, count;
    Node prev, next;
    public Node(int key, int value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
    }
}


class DLL {
    
    private Node dH, dT;
    private int size;
    
    public DLL() {
        dH = new Node(-1, -1, -1);
        dT = new Node(-1, -1, -1);
        dH.next = dT;
        dT.prev = dH;
        this.size = 0;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public Node getdH() {
        return this.dH;    
    }
    
    public Node getdT() {
        return this.dT;    
    }
    
    public void insert(Node node) {
        this.dH.next.prev = node;
        node.next = this.dH.next;
        this.dH.next = node;
        node.prev = this.dH;
        this.size++;
    }
    
    public void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        this.size--;
    }
}

class LFUCache {

    private HashMap<Integer, Node> map1; // key -> node ( to know if this key exists)
    private HashMap<Integer, DLL> map2; // count -> DLL (list of nodes with same count )
    private int min_freq;
    private int capacity;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.min_freq = 0;
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map1.get(key);
        if(node == null) 
            return -1;
        // update the count, update this in map2 and move this node to the front of the DLL
        update(node); 
        return node.value;
    }
    
    public void put(int key, int value) {
        boolean contains = map1.containsKey(key);
        if(!contains) {
            // before inserting, check for capacity
            if(map1.size() >= capacity) {
                DLL dll = map2.get(min_freq);
                Node rm = dll.getdT().prev;
                dll.remove(rm);
                map1.remove(rm.key);
            }
            Node node = new Node(key, value, 1);
            map1.put(key, node);
            min_freq = 1;
            map2.putIfAbsent(min_freq, new DLL());
            DLL dll = map2.get(min_freq);
            dll.insert(node);
            map2.put(min_freq, dll);
        } else {
            Node node = map1.get(key);
            node.value = value;
            update(node);
        }
    }

    private void update(Node node) {
        int count = node.count;
        DLL dll = map2.get(count);
        
        dll.remove(node);
        if(dll.getSize() == 0 && min_freq == node.count) min_freq ++;
        
        node.count++;
        
        map2.putIfAbsent(node.count, new DLL());
        dll = map2.get(node.count);
        dll.insert(node);
        map2.put(node.count, dll);
    }
}