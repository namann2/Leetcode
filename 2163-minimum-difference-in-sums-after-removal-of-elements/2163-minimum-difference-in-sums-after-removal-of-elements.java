class Solution {
    public long minimumDifference(int[] nums) {
        
        long[]left = findLeft(nums);
        long[]right = findRight(nums);
        
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        
        long min = Long.MAX_VALUE;
        int n = nums.length;
        int k = nums.length / 3;
        
        for(int i=k-1;i<n-k;i++) {
            long curr = left[i] - right[i+1];
            min = Math.min(min, curr);
        }
        return min;
    }
    private long[] findLeft(int[] nums) {
        int n = nums.length, k = n/3;
        long[]left = new long[n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        
        long sum = 0;
        
        for(int i=0;i<n;i++) {
            maxHeap.add(nums[i]);
            sum += nums[i];
            if(maxHeap.size() > k) {
                sum -= maxHeap.poll();
            }
            if(maxHeap.size() == k) left[i] = sum;
        }
        return left;
    }
    
    private long[] findRight(int[] nums) {
        int n = nums.length, k = n/3;
        long[]right = new long[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        long sum = 0;
        
        for(int i=n-1;i>=0;i--) {
            minHeap.add(nums[i]);
            sum += nums[i];
            if(minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            if(minHeap.size() == k) right[i] = sum;
        }
        return right;
    }
}