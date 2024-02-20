class Solution {
    public int missingNumber(int[] nums) {
        // Different approaches to solve this : 
        // xor and binary search approch is better
        Arrays.sort(nums);
        int start = 0, end = nums.length-1, ans = -1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == mid) { // there is no missing uptil this point
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans == -1 ? nums.length : ans;
    }
}