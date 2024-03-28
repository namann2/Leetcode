class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, itr = 0, right = n-1;
        while(itr <= right) {
            if(nums[itr] == 0) {
                swap(nums, itr, left);
                left++;
                itr++;
            } else if(nums[itr] == 1) {
                itr++;
            } else {
                swap(nums, itr, right);
                right--;
            }
        }
    }
    private void swap(int[] A, int l, int r) {
        int tmp = A[l];
        A[l] = A[r];
        A[r] = tmp;
    }
}