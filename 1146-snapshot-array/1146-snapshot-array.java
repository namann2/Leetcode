class SnapshotArray {
    
    TreeMap<Integer, Integer>[] map; // for an array. The ith index stores snapId -> value
    int cntSnap;
    public SnapshotArray(int length) {
        map = new TreeMap[length];
        cntSnap = 0;
        for(int i = 0; i < length; i++)
            map[i] = new TreeMap<>();
    }
    
    public void set(int index, int val) {
        map[index].put(cntSnap, val);
    }
    
    public int snap() {
        return cntSnap++;
    }
    
    public int get(int index, int snap_id) {
        Integer key = map[index].floorKey(snap_id);
        if(key == null) return 0;
        return map[index].get(key);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */