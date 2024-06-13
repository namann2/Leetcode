class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums;
        mergeSort(nums, new int[n], 0, n-1);
        return nums;
    }
    
    private void mergeSort(int[] nums, int[] temp, int leftStart, int rightEnd) {
        // base case
        if(leftStart >= rightEnd) 
            return;
        // main logic
        int mid = leftStart + (rightEnd - leftStart) / 2;
        mergeSort(nums, temp, leftStart, mid);
        mergeSort(nums, temp, mid + 1, rightEnd);
        mergeHalves(nums, temp, leftStart , rightEnd);
    }
    
    private void mergeHalves(int[] nums, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = leftStart + (rightEnd - leftStart) / 2;
        int rightStart = leftEnd + 1;
        
        int left = leftStart, right = rightStart, index = leftStart;
        while(left <= leftEnd && right <= rightEnd) {
            if(nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else temp[index++] = nums[right++];
        }
        
        while(left <= leftEnd) temp[index++] = nums[left++];
        while(right <= rightEnd) temp[index++] = nums[right++];
        
        for(int i = leftStart; i <= rightEnd; i++)
            nums[i] = temp[i];
    }
}