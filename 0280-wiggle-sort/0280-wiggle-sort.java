class Solution {
    public void wiggleSort(int[] nums) {
        // naive_sorting(nums);
        greedy(nums);
    }
    private void naive_sorting(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=1;i<n-1;i+=2) {
            swap(nums, i, i+1);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
    private void greedy(int[] nums) {
        // observation : even index elements should be smaller then next elements and 
        // odd index elements should be greater than next elements
        int n = nums.length;
        for(int i=0;i<n-1;i++) {
            if((i%2 == 0 && nums[i] > nums[i+1]) || (i%2 == 1 && nums[i] < nums[i+1]))
                swap(nums, i, i+1);
        }
    }
}