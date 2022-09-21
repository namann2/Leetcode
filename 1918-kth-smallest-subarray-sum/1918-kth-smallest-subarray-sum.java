class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        // Naive solution is to generate all possible subarray sum
        // and maintain a k size max heap
        // The issue is time complexity would become n^2 * log k - TLE
        // we need to calculate the subarray sum in an optimal manner
        
        // 1 2 3 4
        // max = 10 ( sum )
        // min = 1 ( min )
        
        // We are binary searching over the subarray sums and finding the positions of the subarray
        // with sum = mid, we want k-1 subarrays to be on the left to be able to say that the kth subarray is the one which 
        // our current mid(sum) points to.
        
        int max = 0, min = 0;
        for(int num : nums) {
            max += num;
            min = Math.min(min, num);
        }
        
        int start = min, end = max, ans = 0;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(numberOfSubarraysLessThanK(nums, mid) >= k) { // number of subarrays on the left with sum less than the mid
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
    private int numberOfSubarraysLessThanK(int[] A, int sum) {
        int cnt = 0;
        int begin = 0, end = 0, n = A.length, csum = 0;
        while(end < n) {
            csum += A[end];
            while(csum > sum) 
                csum -= A[begin++];
            cnt += end - begin + 1;
            end++;
        }
        return cnt;
    }
}