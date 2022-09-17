class Solution {
    public int findPairs(int[] A, int k) {
        // a - b = k can be written as a = b + k
        // a - b = k can also be written as a - k = b
        // Thus, we need to find if for a number X -> X-k and X+k exists or not.
        int n = A.length, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            int n1 = A[i] + k;
            int n2 = A[i] - k;
            // same value pairs eg : [1,1] will only be counted once as we want unique pairs
            if(k == 0 && map.getOrDefault(A[i], 0) == 1) count++;
            else {
                if(map.containsKey(A[i])) continue; // we have already seen the A[i] and would have formed the pair already
                if(map.containsKey(n1)) count++;
                if(map.containsKey(n2)) count++;
            }
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
        }
        return count;
    }
}
