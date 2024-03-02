class Node {
    int key, value, count;
    Node prev, next;
    Node(int key, int value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
    }
}

class DLL {
    Node dH, dT;
    int size;
    public DLL() {
        dH = new Node(-1, -1, -1);
        dT = new Node(-1, -1, -1);
        dH.next = dT;
        dT.prev = dH;
        size = 0;
    }
    
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
    
    public void insert(Node node) {
        dH.next.prev = node;
        node.next = dH.next;
        dH.next = node;
        node.prev = dH;
        size++;
    }
}

class LFUCache {

    private Map<Integer, Node> map1; // key to node mapping
    private Map<Integer, DLL> map2; // frequency to DLL of nodes with that freq
    private int max_capacity, min_freq;
    
    public LFUCache(int capacity) {
        map1 = new HashMap<>();
        this.max_capacity = capacity;
        map2 = new HashMap<>(max_capacity);
        min_freq = 0;
    }
    
    public int get(int key) {
        Node node = map1.get(key);
        if(node == null) 
            return -1;
        
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map1.containsKey(key)) {
            Node node = map1.get(key);
            node.value = value;
            update(node);
        } else {
            if(map1.size() >= max_capacity) { // remove element in LFU or if multiple elements for same freq, in LRU way
                DLL list = map2.get(min_freq);
                Node node = list.dT.prev;
                map1.remove(node.key);
                list.remove(node);
            }
            min_freq = 1;
            Node node = new Node(key, value, 1);
            map1.put(key, node);
            DLL newList = map2.getOrDefault(node.count, new DLL());
            newList.insert(node);
            map2.put(node.count, newList);
        }
    }
    
    // remove and insert with all logic in DLL and hashmaps
    private void update(Node node) {
        // remove 
        DLL oldList = map2.get(node.count);
        oldList.remove(node);
        // if I am removing the min freq node
        if(node.count == min_freq && oldList.size == 0) min_freq++;
        // increment freq of node and update it in the DLL of new freq
        
        // insert
        node.count++;
        DLL newList = map2.getOrDefault(node.count, new DLL());
        newList.insert(node);
        map2.put(node.count, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */






