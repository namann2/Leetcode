class Solution {
    public long kSum(int[] nums, int k) {
        /*
            If we go about finding all the subsequences then, our time complexity will be around
            2^n but n is too large and hence it can not be done this way.
            
            We need to find the K th largest subsequence, what will we (while deciding the subsequence logic) do some 
            optimization and cleverly create just required K subsequences ? Can we do that ?
            Yes, we can since that is the demand of the question, but how ?
            
            
            The largest subsequence would be the sum of all positive numbers in the array
            what will be the second largest subsequence ?
            We could remove smallest number from the largest subsequence that we created above ? or 
            since the numbers are negative as well, we could add largest negative number.
            
            All in all we are removing smallest (absolute) number from the subsequence right ?
            [4,-2,-1,2,4,5,6]
            
            K=1 largest subsequence will be sum of all positive values = 2 + 4 + 5 + 6 = 17
            K=2, we can do the following
                - remove largest negative number 17 - 1 = 16
                - remove smallest positive number 17 - 2 = 15
                choose maximum from these. which is when we remove 1 ( smallest absolute )
                But the important observation is, we are removing the absolute smallest value
                
                
                The first largest value would be the maxSubsequenceSum
                The second largest value would be the maxSubsequenceSum - nums[0]
                The third largest value would be the 
                1-maxSubsequenceSum + nums[0] - nums[1] ( currmax + nums[0] - nums[1] ) - remove the second  min
                2-maxSubsequenceSum - nums[1] ( currmax - nums[0] - nums[1] ) - continue removing elements
              
        */
        
        long maxSubsequenceSum = 0;
        long n = nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i] > 0) maxSubsequenceSum += nums[i];
            else nums[i] = -nums[i];
        }
        
        if(k==1) return maxSubsequenceSum;
        
        Arrays.sort(nums);
        PriorityQueue<long[]> pq = new PriorityQueue<>((i1, i2)->{
            return Long.compare(i2[0], i1[0]);
        });
        
        List<Long> sums = new ArrayList<>();
        sums.add(maxSubsequenceSum);
        
        pq.add(new long[]{maxSubsequenceSum - nums[0], 2, 0});
        
        while(!pq.isEmpty() && sums.size() < k) {
            long[]curr = pq.poll();
            long sum = curr[0], currK = curr[1];
            int index = (int)curr[2];
            sums.add(sum);
            if(index+1 <= n-1) {
                pq.add(new long[]{sum + nums[index] - nums[index+1], currK+1, index+1});
                pq.add(new long[]{sum - nums[index+1], currK+1, index+1});
            }
            // System.out.println(sums);
        }
        // System.out.println(sums);
        return sums.get(k-1);
    } 
}