class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int f, int s) {
        return Math.max(maxSum(nums, f, s), maxSum(nums, s, f));
    }
    private int maxSum(int[] nums, int len1, int len2) {
        int n = nums.length;
        int[]dp1 = new int[n];
        int[]dp2 = new int[n];
        
        int end = 0, begin = 0, sum = 0;
        while(end < n) {
            sum += nums[end];
            if(end-begin+1 == len1) {
                dp1[end] = Math.max(end-1 >= 0 ? dp1[end-1] : 0, sum);
                sum -= nums[begin++];
            }
            end++;
        }
        
        end = n-1;
        begin = n-1;
        sum = 0;
        
        while(begin >= 0) {
            sum += nums[begin];
            if(end - begin + 1 == len2) {
                dp2[begin] = Math.max(begin+1 < n ? dp2[begin+1] : 0, sum);
                sum -= nums[end--];
            }
            begin--;
        }

        int max_sum = 0;
        for(int i=0;i<n-1;i++) {
            max_sum = Math.max(max_sum, dp1[i] + dp2[i+1]);
        }
        return max_sum;
    }
}