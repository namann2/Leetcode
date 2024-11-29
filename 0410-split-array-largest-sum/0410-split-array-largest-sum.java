class Solution {
    public int splitArray(int[] nums, int k) {
        /*
            - Binary Search on Answer
                - combination 1 to break array into k subarrays : [s1][s2][s3][s4] = max(s1, s2, s3,s4) = A
                - combination 2 to break array into k subarrays : [s1][s2][s3][s4] = max(s1, s2, s3,s4) = B
                ...
                - combination m to break array into k subarrays : [s1][s2][s3][s4] = max(s1, s2, s3,s4) = M
                
                ans = min(A, B,.....M)
                
            - Observations : 
                - sorting not applicable
                - k is at max 50
                    - DP states would be minimal -> we could actually use dp
                - prefix sum is indeed helpful
        */
        
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        /*
            I was not really confident on the range of end here. 
            Acc to my understanding, at best/worst k = 1, the largest summation a partition could have is sum - something. 
            Now, since we do not know what that something is, we expand the range and say end = sum. Ideally, since the array 
            is not sorted, we can not say sum - min(or A[0]). Hence, it is better to keep the range sub-optimal.
        */
        int start = max, end = sum, ans = 0;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int partitions = numberOfPartitions(nums, mid, n);
            if(partitions <= k) {
                ans = mid;
                end = mid - 1; // we need more paritions, hence we reduce the summation 
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    
    private int numberOfPartitions(int[] nums, int target, int n) {
        int partitions = 1, sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(sum > target) {
                partitions ++;
                sum = nums[i];
            }
        }
        return partitions;
    }
}
