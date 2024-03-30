class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1, p2) -> {
            return p1.getValue() - p2.getValue();
        });
        
        
        for(int num : map.keySet()) {
            pq.offer(new Pair(num, map.get(num)));
            if(pq.size() > k) pq.poll();
        }
        
        int[] answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) 
            answer[idx++] = pq.poll().getKey();
        
        return answer;
    }
}