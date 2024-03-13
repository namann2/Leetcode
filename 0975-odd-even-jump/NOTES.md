```
class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        /* 
            n - 1 is always a good start point, 
            regardless it's odd or even step.
        */
        even[n-1] = odd[n-1] = true;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n-1], n-1);
        
        for(int i=n-2;i>=0;i--) {
            Integer hi = map.ceilingKey(A[i]);
            if(hi != null) odd[i] = even[map.get(hi)];
            
            Integer lo = map.floorKey(A[i]);
            if(lo != null) even[i] = odd[map.get(lo)];
            
            map.put(A[i], i);
        }
        
        // Finally, since we always start with an odd jump (1), we want to see how many
        // good jumps we have in the odd[] boolean array and this is our answer
        // We could have done this in the above loop but the flow is as is.
        
        int cnt = 0;
        for(int i=0;i<n;i++) 
            cnt += (odd[i]) ? 1 : 0;
        
        return cnt;
    }
}
```
