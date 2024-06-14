class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        // element -> list of indices
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        boolean[] even = new boolean[n];
        boolean[] odd = new boolean[n];
        
        even[n-1] = odd[n-1] = true;
        map.put(A[n-1], n-1);
        
        int cnt = 1;
        for(int i = n-2; i >= 0; i--) {
            Integer nextOddJump = map.ceilingKey(A[i]);
            if(nextOddJump != null)
                odd[i] = even[map.get(nextOddJump)];
            
            Integer nextEvenJump = map.floorKey(A[i]);
            if(map.floorKey(A[i]) != null)
                even[i] = odd[map.get(nextEvenJump)];
            
            cnt += odd[i] == true ? 1 : 0;
            map.put(A[i], i);
        }
        return cnt;
    }
}