class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n-1, new int[n]);
        return nums;
    }
    private void mergeSort(int[] nums, int leftStart, int rightEnd, int[] temp) {
        if(leftStart == rightEnd) 
            return;
        
        int mid = leftStart + (rightEnd - leftStart) / 2;
        
        mergeSort(nums, leftStart, mid, temp);
        mergeSort(nums, mid + 1, rightEnd, temp);
        mergeHalves(nums, leftStart, mid, rightEnd, temp);
    }
    private void mergeHalves(int[] nums, int leftStart, int leftEnd, int rightEnd, int[] temp) {
        int rightStart = leftEnd + 1;
        int left = leftStart, right = rightStart, index = leftStart;
        
        while(left <= leftEnd && right <= rightEnd) {
            if(nums[left] <= nums[right]) {
                temp[index] = nums[left];
                left++;
            } else {
                temp[index] = nums[right];
                right++;
            }
            index++;
        }
        
        while(left <= leftEnd) temp[index++] = nums[left++];
        while(right <= rightEnd) temp[index++] = nums[right++];
        for(int i=leftStart;i<=rightEnd;i++)
            nums[i] = temp[i];
    }
}