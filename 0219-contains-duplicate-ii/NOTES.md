# HashSet - Sol1
```
        HashSet<Integer> seen = new HashSet<>();
        int end = 0, begin = 0, n = A.length-1;
        while(end <= n) {
            if(!seen.add(A[end])) return true;
            if(end-begin+1 > k)
                seen.remove(A[begin++]);
            end++;
        }
        return false;
```

# HashMap - Sol2
```
class Solution {
    public boolean containsNearbyDuplicate(int[] A, int k) {
        
        /*
        Logic : to store last indices of every element
        
        [1,2,3,1]
            if we are currently at i=3
            1->0
            2->1
            3->2
            
            now, 1 is already present in the hashmap means we would get an answer by checking the 
            condition that whether we are in valid window size or not.
            1. If we are, return true
            2. else, we are out of the valid window and so we will update the latest index in map
            because the earlier mapping is out of the window and gping ahead it won't help us in the 
            answer (as it would still be out of the window) so we update the latest index in mapping
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i]) && i - map.get(A[i]) <= k) return true;
            map.put(A[i], i);
        }
        return false;
    }
}
```
