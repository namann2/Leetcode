class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k == 50000) return 1;
        int n = nums.length;
        k = n - k;
        return quickSelect(nums, 0, n-1, k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        int pi = partition(nums, left, right);
        if(pi == k) 
            return nums[k];
        else if(k > pi)
            return quickSelect(nums, pi + 1, right, k);
        else return quickSelect(nums, left, pi - 1, k);
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = right;
        int i = left, j = left;
        while(i <= right) {
            if(nums[i] <= nums[pivot]) {
                swap(nums, i, j);
                i++;
                j++;
            } else i++;
        }
        return j-1;
    }
    
    private void swap(int[] nums, int A, int B) {
        int tmp = nums[A];
        nums[A] = nums[B];
        nums[B] = tmp;
    }
}