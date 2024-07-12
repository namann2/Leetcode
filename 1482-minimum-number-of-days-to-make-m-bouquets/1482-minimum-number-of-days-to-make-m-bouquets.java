class Solution {
    public int minDays(int[] A, int m, int k) {
        int n = A.length;
        if(m * k > n) 
            return -1;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int timeToBloom : A) {
            min = Math.min(min, timeToBloom);
            max = Math.max(max, timeToBloom);
        }
        // a b c d e f g h i j
        // f f f t t t t t t t
        //.    e.s 
        int start = min, end = max, ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int numberOfBouqets = findBouqets(A, mid, k);
            if(numberOfBouqets >= m) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
    
    private int findBouqets(int[] A, int days, int k) {
        // in given days using k consecutive flowers, how many bouqets can be created.
        // thus, we can use those flowers who can bloom within <= days.
        int cntOfBouqets = 0, consecutive = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] <= days) {
                consecutive++;
            } else consecutive = 0;
            
            if(consecutive == k) {
                cntOfBouqets++;
                consecutive = 0;
            }
        }
        return cntOfBouqets;
    }
}