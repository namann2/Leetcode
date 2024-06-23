class Solution {
    public int findLeastNumOfUniqueInts(int[] A, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : A) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        
        for(int num : count.keySet()) {
            pq.offer(count.get(num));
        }
        
        while(!pq.isEmpty() && k > 0) {
            int freq = pq.poll();
            if(freq <= k) k -= freq;
            else {
                freq -= k;
                if(freq > 0) pq.offer(freq);
                break;
            }
        }
        
        return pq.size();
    }
}