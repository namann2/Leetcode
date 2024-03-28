class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        /*
            Started off with a normal LIS solution, double loop but the issue with that is,
            it is n^2 and the constraints won't allow this solution. Hence, this is hard.
            
            Intuition for optimal : 
            For a particular number, we only care about the k max sum. 
            If we can get a max sum out of those k values for an index i, 
            we can do the solution in less time complexity. How can we do it ?
            
            Using heaps.
        */
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        }); // [index, nums[index]]
        int n = nums.length, maxsum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            while(!maxHeap.isEmpty() && i - maxHeap.peek()[0] > k) {
                maxHeap.remove();
            }
            int currsum = nums[i] + (maxHeap.isEmpty() ? 0 : maxHeap.peek()[1]);
            currsum = Math.max(currsum, nums[i]); // we can consider only nums[i]
            maxHeap.offer(new int[]{i, currsum});
            maxsum = Math.max(maxsum, currsum);
        }
        return maxsum;
    }
}