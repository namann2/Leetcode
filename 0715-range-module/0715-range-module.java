class RangeModule {
    
    TreeMap<Integer, Integer> map;
    
    public RangeModule() {
        map = new TreeMap<>();    
    }
    
    public void addRange(int left, int right) {
        Integer leftStart = map.floorKey(left); 
        // Integer leftEnd = map.get(leftStart);
        Integer rightStart = map.floorKey(right);
        // Integer rightEnd = map.get(rightStart);
        
        if(leftStart != null && left <= map.get(leftStart)) {
            left = leftStart;
        }
        
        if(rightStart != null && right <= map.get(rightStart)) {
            right = map.get(rightStart);
        }
        
        map.put(left, right);
        map.subMap(left, false, right, true).clear();
    }
    
    public boolean queryRange(int left, int right) {
        Integer leftStart = map.floorKey(left);
        if(leftStart == null) return false;
        return right <= map.get(leftStart);
    }
    
    public void removeRange(int left, int right) {
        // System.out.println("Remove Range : "+left+" :: "+right);
        
        Integer leftStart = map.floorKey(left);
        // Integer leftEnd = map.get(leftStart);
        Integer rightStart = map.floorKey(right);
        // Integer rightEnd = map.get(rightStart);
        
        if(rightStart != null && right < map.get(rightStart)) {
            map.put(right, map.get(rightStart));
        }
        
        if(leftStart != null && left < map.get(leftStart)) {
            map.put(leftStart, left);
        }
        
        map.subMap(left, true, right, false).clear();
        
        // System.out.println("After Operation");
        // System.out.println(map);
    }
}

// class RangeModule {
//     TreeMap<Integer, Integer> intervals = new TreeMap<>();
    
//     public void addRange(int left, int right) {
//         Integer start = intervals.floorKey(left);
//         Integer end = intervals.floorKey(right);
//         if(start != null && intervals.get(start) >= left){
//             left = start;
//         }
//         if(end != null && intervals.get(end) > right){
//             right = intervals.get(end);
//         }
//         intervals.put(left, right);
       
//         intervals.subMap(left, false, right, true).clear();
//     }
    
//     public boolean queryRange(int left, int right) {
//         Integer start = intervals.floorKey(left);
//         if(start == null) return false;
//         return intervals.get(start) >= right;
//     }
    
//     public void removeRange(int left, int right) {
//         Integer start = intervals.floorKey(left);
//         Integer end = intervals.floorKey(right);

//         if(end != null && intervals.get(end) > right){
//             intervals.put(right, intervals.get(end));
//         }
//         if(start != null && intervals.get(start) > left){
//             intervals.put(start, left);
//         }
//         intervals.subMap(left, true, right, false).clear();
//     }
// }