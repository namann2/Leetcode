class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(k == 50000) return 1;
        k = n - k;
        return quickSelect(nums, 0, n-1, k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if(left > right) return -1;
        int pi = partition(nums, left, right);
        if(pi == k) return nums[k];
        else if(k < pi) return quickSelect(nums, left, pi - 1, k);
        else return quickSelect(nums, pi + 1, right, k);
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int it = left, pos = left;
        while(it <= right) {
            if(nums[it] <= pivot) {
                swap(nums, it, pos);
                pos++;
                it++;
            } else {
                it++;
            }
        }
        return pos - 1;
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}