class Node {
    Node prev, next;
    Set<String> buckets;
    int freq;
    Node(int freq) {
        this.freq = freq;
        this.buckets = new HashSet<>();
    }
}
class AllOne {

    Node dH, dT;
    Map<Integer, Node> map1;
    Map<String, Integer> map2;

    public AllOne() {
        dH = new Node(-1);
        dT = new Node(-1);
        dH.next = dT;
        dT.prev = dH;
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void inc(String key) {
        boolean contains = map2.containsKey(key);
        if(contains) {
            update(key, 1);
        } else {
            map2.put(key, 1);
            if(dH.next.freq != 1) 
                insertNodeAfter(new Node(1), dH);
            dH.next.buckets.add(key);
            map1.put(1, dH.next);
        }
    }
    
    public void dec(String key) {
        boolean contains = map2.containsKey(key);
        if(contains) {
            int count = map2.get(key);
            if(count == 1) {
                map2.remove(key);
                removeKeyFromBucket(map1.get(count), key);
            } else {
                update(key, -1);
            } 
        }
    }
    
    public String getMaxKey() {
        return dT.prev == dH ? "" : dT.prev.buckets.iterator().next();
    }
    
    public String getMinKey() {
        return dH.next == dT ? "" : dH.next.buckets.iterator().next();
    }
    
    private void insertNodeAfter(Node node, Node ref) {
        ref.next.prev = node;
        node.next = ref.next;
        ref.next = node;
        node.prev = ref;
    }
    
    private void update(String key, int value) {
        int prev_count = map2.get(key);
        int new_count = prev_count + value;
        
        map2.put(key, new_count);
        Node currBucket = map1.get(prev_count);
        
        Node newBucket;
        // target Bucket already exists
        if (map1.containsKey(new_count)) {
            newBucket = map1.get(new_count);
        } else {
            // add new Bucket
            newBucket = new Node(new_count);
            map1.put(new_count, newBucket);
            insertNodeAfter(newBucket, value == 1 ? currBucket : currBucket.prev);
        }
        newBucket.buckets.add(key);
        removeKeyFromBucket(currBucket, key);
    }
    private void removeKeyFromBucket(Node node, String key) {
        node.buckets.remove(key);
        if (node.buckets.size() == 0) {
            removeBucketFromList(node);
            map1.remove(node.freq);
        }
    }
    private void removeBucketFromList(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}