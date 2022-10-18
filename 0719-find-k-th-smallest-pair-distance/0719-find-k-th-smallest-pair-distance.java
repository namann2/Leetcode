class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int start = 0, end = nums[n-1] - nums[0], ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int count = getCount(nums, mid);
            if(count >= k) { // if the number of pairs are too much then we have to reduce the difference 
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
    private int getCount(int[] nums, int diff) {
        int cnt = 0;
        int begin = 0, end = 0, n = nums.length;
        while(end < n) {
            while(nums[end] - nums[begin] > diff) begin++;
            cnt += end - begin; // number of subarrays between begin and end pointers
            end++;
        }
        return cnt; // number of subarrays with difference between the elements less than equal to diff
    }
}