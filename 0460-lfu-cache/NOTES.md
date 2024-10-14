```
// node structure for storing key-value in cache
class Node {
    int key, value, freq;
    Node prev, next;
    public Node(int key, int value, int freq) {
        this.key = key;
        this.value = value;
        this.freq = freq;
    }
}

class DLL {
    public Node dH, dT; // TODO : improve data-hiding 
    public int size; // TODO : improve data-hiding 
    public DLL() {
        this.dH = new Node(-1, -1, -1);
        this.dT = new Node(-1, -1, -1);
        this.dH.next = dT;
        this.dT.prev = dH;
        this.size = 0;
    }
    
    // remove the node from DLL
    public void remove(Node nodeToRemove) {
        nodeToRemove.next.prev = nodeToRemove.prev;
        nodeToRemove.prev.next = nodeToRemove.next;
        this.size--;
    }
    
    // insert a node in DLL
    public void insert(Node nodeToInsert) {
        this.dH.next.prev = nodeToInsert;
        nodeToInsert.next = this.dH.next;
        this.dH.next = nodeToInsert;
        nodeToInsert.prev = this.dH;
        this.size++;
    }
}

class LFUCache {
    // key -> node(key, value, freq)
    private Map<Integer, Node> map1;
    // freq -> DLL (in LRU Fashion)
    private Map<Integer, DLL> map2;
    private int minFreq;
    private int capacity;
    
    public LFUCache(int capacity) {
        this.map1 = new HashMap<>();
        this.map2 = new HashMap<>();
        this.minFreq = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // if key does not exist in the map
        if(!map1.containsKey(key)) {
            return -1;
        }
        
        Node nodeKey = map1.get(key);
        // update the freq of the key ->
        updateFrequency(nodeKey);
        return nodeKey.value;
    }
    
    public void put(int key, int value) {
        boolean contains = map1.containsKey(key);
        if(!contains) {
            // validate the size of LFUCache
            if(map1.size() >= capacity) {
                // get the DLL from which we need to remove the node to make size within capacity
                DLL dll = map2.get(minFreq);
                // remove the LRU from DLL
                map1.remove(dll.dT.prev.key);
                Node nodeToRemove = dll.dT.prev;
                dll.remove(nodeToRemove);
            }
            // add the new key, value to the cache
            Node newNode = new Node(key, value, 1);
            // update the minFrequency
            minFreq = 1;
            // insert the node to map1
            map1.put(key, newNode);
            map2.putIfAbsent(minFreq, new DLL());
            DLL dll = map2.get(minFreq);
            dll.insert(newNode);
        } else {
            // the key already exist
            Node node = map1.get(key);
            node.value = value;
            updateFrequency(node);
        }
    }
    
    /* helper functions */
    private void updateFrequency(Node node) {
        // get the current freq of the node
        int freq = node.freq;
        // get the DLL for the current frequency
        DLL dll = map2.get(freq);
        // remove the current node from current DLL
        dll.remove(node);
        // update the minFreq for LFU use-case
        if(dll.size == 0 && minFreq == freq) minFreq++;
        // update the frequency of the node
        node.freq = ++freq;
        // if new freq does not exist in map2, make an entry
        map2.putIfAbsent(freq, new DLL());
        dll = map2.get(freq);
        // add the node to DLL corresponding to new freq
        dll.insert(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```​
