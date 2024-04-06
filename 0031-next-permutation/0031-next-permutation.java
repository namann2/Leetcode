class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int position = -1;
        for(int i = n - 1; i > 0; i--) {
            if(nums[i] > nums[i-1]) {
                position = i-1;
                break;
            }
        }
        
        if(position == -1) {
            reverse(nums, 0, n-1);
            return;
        }
        
        int next_big = position;
        for(int k = position + 1; k < n; k++) {
            if(nums[position] < nums[k]) {
                next_big = k;
            }
        }
        
        swap(nums, position, next_big);
        reverse(nums, position + 1, n-1);
    }
    private void reverse(int[] nums, int L, int R) {
        while(L <= R) {
            if(nums[L] > nums[R]) {
                swap(nums, L, R);
            }
            L++;
            R--;
        }
    }
    private void swap(int[] nums, int L, int R) {
        int temp = nums[L];
        nums[L] = nums[R];
        nums[R] = temp;
    }
}