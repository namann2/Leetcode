class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q)->{
            return p[0]-q[0]; // freq
        });
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        for(int num : count.keySet()) {
            pq.offer(new int[]{count.get(num), num});
            if(pq.size() > k)
                pq.remove();
        }
        
        int n = pq.size(), idx = 0;
        int[] ans = new int[n];
        while(!pq.isEmpty())
            ans[idx++] = pq.poll()[1];
        
        return ans;
    }
}