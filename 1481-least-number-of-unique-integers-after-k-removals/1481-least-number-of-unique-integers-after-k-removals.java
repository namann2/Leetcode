class Solution {
    public int findLeastNumOfUniqueInts(int[] A, int k) {
        int n = A.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        
        for(int a : A)
            cnt.put(a, cnt.getOrDefault(a, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(cnt.values());
        
        while(pq.size() > 0 && k > 0) {
            int currCnt = pq.poll();
            k -= currCnt;
            if(k < 0)
                return pq.size() + 1;
        }
        
        return pq.size();
    }
}
// 4 - 1, 3 - 3, 1 - 2, 2 -  1
// 4-1, 2-1, 1-2, 3-3
// k = 3