class Solution {
    public int subarraysWithKDistinct(int[] A, int k) {
        int ak = atmostK(A, k);
        int ak_1 = atmostK(A, k-1);
        int exactly = ak - ak_1;
        return exactly;
    }
    private int atmostK(int[]A, int k) {
        int n = A.length;
        int begin = 0, end = 0, cnt = 0;
        Map<Integer, Integer> count = new HashMap<>();
        while(end < n) {
            count.put(A[end], count.getOrDefault(A[end], 0)+1);
            while(count.size() > k && begin < end) {
                int rm = A[begin];
                count.put(rm, count.get(rm)-1);
                if(count.get(rm) == 0) count.remove(rm);
                begin++;
            }
            if(count.size() <= k)
                cnt += end - begin + 1; // subarrays with atmost k characters ending at A[end]
            end++;
        }
        return cnt;
    }
}