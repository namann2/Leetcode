class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        /*
            This is simple if we run two nested loops queries * nums
            Summation of the difference of each nums[j] with queries[i] BUT !
            the constraints need better approach.
            We need to do it under O(n log n)
            
            Notice that the order of elements does not matter in the given input based on 
            the query we need to perform.
            
            Hints : [ When to use prefix-sum technique ]
            1. Non-changing array: If the array is static and does not change between queries or calculations. 
                                This allows us to preprocess the array once and then answer 
                                multiple queries efficiently.
                                
            2. Repetitive sum calculations: If we need to repeatedly calculate the sum of elements 
                                            in a certain range or subarray of the array. It is a simple
                                            case for range sum as well.
        */
        int n = nums.length;
        Arrays.sort(nums);
        
        long[] prefix_sum = new long[n];
        prefix_sum[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + nums[i];
        }
        
        int qlength = queries.length;
        List<Long> result = new ArrayList<>();
        for(int i = 0; i < qlength; i++) result.add(0l);
        
        for(int i = 0; i < qlength; i++) {
            int start = 0, end = n-1;
            while(start <= end) {
                int mid = (start + end) >> 1;
                if(nums[mid] >= queries[i]) {
                    end = mid - 1;
                } else start = mid + 1;
            }
            
            // start index points to the value that is just greater than or equal to query[i]
            long pre = start - 1 >= 0 ? 1l * prefix_sum[start - 1] : 0;
            long curr_smaller = (1l * queries[i] * start) - pre;
            long curr_larger = (prefix_sum[n - 1] - pre) - (1l * queries[i] * (n - start));
            result.set(i, curr_smaller + curr_larger);
        }
        return result;
    }
}