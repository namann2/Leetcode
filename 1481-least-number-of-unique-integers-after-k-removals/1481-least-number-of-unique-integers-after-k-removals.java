class Solution {
    public int findLeastNumOfUniqueInts(int[] A, int k) {
        int n = A.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        
        for(int a : A)
            cnt.put(a, cnt.getOrDefault(a, 0) + 1);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];    
        });
        
        for(int num : cnt.keySet()) {
            pq.offer(new int[]{num, cnt.get(num)});
        }
        
        while(pq.size() > 0 && k > 0) {
            int[] currCnt = pq.poll();
            if(currCnt[1] <= k) {
                k -= currCnt[1];
            } else {
                currCnt[1] -= k;
                k = 0;
                pq.offer(currCnt);
            }
        }
        
        return pq.size();
    }
}
// 4 - 1, 3 - 3, 1 - 2, 2 -  1
// 4-1, 2-1, 1-2, 3-3
// k = 3