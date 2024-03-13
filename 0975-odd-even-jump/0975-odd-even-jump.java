class Solution {
    public int oddEvenJumps(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = A.length;
        // for a particular index, check if we can reach the end if we make even number jump/odd number jump
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        
        /* 
            n - 1 is always a good start point, 
            regardless it's odd or even step.
        */
        odd[n-1] = even[n-1] = true;
        
        int cnt = 1;
        map.put(A[n-1], n-1);
        
        for(int i = n - 2; i >= 0 ; i--) {
            Integer oddJumpIndex = map.ceilingKey(A[i]);
            if(oddJumpIndex != null)
                odd[i] = even[map.get(oddJumpIndex)];
            
            Integer evenJumpIndex = map.floorKey(A[i]);
            if(evenJumpIndex != null)
                even[i] = odd[map.get(evenJumpIndex)];
            
            cnt += true == odd[i] ? 1 : 0;
            map.put(A[i], i);
        }
        return cnt;
    }
}