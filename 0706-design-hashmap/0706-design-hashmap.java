class Node {
    int key;
    int value;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    
    private ArrayList<Node>[] buckets;
    private int size; // how many number of elements it currently has
    private double lf = 0.75f;
    private int capacity = 10001;//1 << 4; // 10001;
    
    private void initBuckets(int capacity) {
        buckets = new ArrayList[capacity];
        for(int i = 0; i < capacity; i++)
            buckets[i] = new ArrayList<>();
        size = 0;
    }
    
    private int getBucketId(int key) {
        return (Integer.hashCode(key)) % buckets.length;    
    }
    
    private int findIndexOfKey(int bucketId, int key) {
        ArrayList<Node> currList = buckets[bucketId];
        int n = currList.size();
        for(int i = 0; i < n; i++) {
            if(currList.get(i).key == key) return i;
        }
        return -1;
    }
    
    private void rehash() {
        int newCapacity = 1 << capacity;
        ArrayList<Node>[] oldBucket = buckets;
        initBuckets(newCapacity);
        
        for(int i = 0; i < oldBucket.length; i++) {
            ArrayList<Node> nodeList = oldBucket[i];
            for(Node node : nodeList) {
                put(node.key, node.value);
            }
        }
    }
    
    public MyHashMap() {
        initBuckets(capacity);
    }
    
    public void put(int key, int value) {
        int bucketId = getBucketId(key);
        int index = findIndexOfKey(bucketId, key);
        
        if(index == -1) {
            buckets[bucketId].add(new Node(key, value));
            size++;
        } else {
            buckets[bucketId].get(index).value = value;
        }
        
        double currLoad = size / capacity;
        if(currLoad >= lf) {
            rehash();
        }
    }
    
    public int get(int key) {
        if(size == 0) return -1;
        
        int bucketId = getBucketId(key);
        int index = findIndexOfKey(bucketId, key);
        
        if(index == -1) return -1;
        return buckets[bucketId].get(index).value;
    }
    
    public void remove(int key) {
        if(size == 0) return;
        int bucketId = getBucketId(key);
        int index = findIndexOfKey(bucketId, key);
        
        if(index != -1) {
            buckets[bucketId].remove(index);
            size--;
        }
    }
}