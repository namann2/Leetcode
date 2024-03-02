OLD TIMES : 😆 
See Back To Back SWE lecture on this ->  basic idea ( do not consider the code implementation of his, it is complex and indeed lengthy )

The code is simple if you understood the logic behind the problem. Otherwise, see Nick White code video for this

# Solution : 

```
class Node {
    int key, value;
    Node prev, next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    
    private Node dH, dT;
    private int maxCapacity = 0;
    private HashMap<Integer, Node> map;
    
    public LRUCache(int capacity) {
        dH = new Node(-1,-1);
        dT = new Node(-1,-1);
        dH.next = dT;
        dT.prev = dH;
        maxCapacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        } 
        if(map.size() >= maxCapacity) {
            remove(dT.prev);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
    }
    
    private void remove(Node node) {
        map.remove(node.key);
        // H - 1 - 2 - 3 - T
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insert(Node node) {
        map.put(node.key, node);
        // H - 1 - 2 - T, 4
        Node tmp = dH.next;
        dH.next = node;
        node.prev = dH;
        
        node.next = tmp;
        tmp.prev = node;
    }
}
```
