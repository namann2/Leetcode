class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // greedy algorithm
        // TC : O(N * Log N)
        // SC : O(N)
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n-1;i++) {
            int curr = heights[i];
            int next = heights[i+1];
            if(curr >= next) continue;
            bricks -= next - curr;
            pq.add(next - curr);
            
            if(bricks < 0) {
                if(ladders == 0) return i;
                bricks += pq.poll();
                ladders--;
            }
        }
        return n-1;
    }
}