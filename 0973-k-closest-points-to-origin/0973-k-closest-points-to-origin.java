class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            int x = Math.abs(p1[0] * p1[0]) + Math.abs(p1[1] * p1[1]), 
            y = Math.abs(p2[0] * p2[0]) + Math.abs(p2[1] * p2[1]);
            return -1 * Integer.compare(x, y);
        });
        
        for(int[] point : points) {
            pq.offer(new int[]{point[0], point[1]});
            if(pq.size() > k) 
                pq.poll();
        }
        
        int[][]result = new int[k][2];
        int idx = 0;
        while(!pq.isEmpty()) {
            result[idx++] = pq.poll();
        }
        return result;
    }
}