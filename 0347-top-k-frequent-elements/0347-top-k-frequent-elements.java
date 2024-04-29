class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q) -> {
            return p[1] - q[1];
        });
        
        Map<Integer, Integer> cnt = new HashMap<>();
        
        for(int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        
        for(int num : cnt.keySet()) {
            pq.offer(new int[]{num, cnt.get(num)});
            if(pq.size() > k)
                pq.poll();
        }
        
        int[] ans = new int[k];
        int idx = 0;
        while(!pq.isEmpty())
            ans[idx++] = pq.poll()[0];
        
        return ans;
    }
}