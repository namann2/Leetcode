class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pos = -1;
        // 1 2 3 4 2 3 1
        // 1 2 3 4 3 2 1
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                pos = i;
                break;
            }
        }
        
        if(pos == -1) {
            reverse(nums, 0, n-1);
            return;
        }
        
        int nextGreater = pos;
        for(int i = pos + 1; i < n; i++) {
            if(nums[i] > nums[pos]) {
                nextGreater = i;
            }
        }
        
        swap(nums, nextGreater, pos);
        reverse(nums, pos + 1, n-1);
    }
    
    private void reverse(int[] nums, int A, int B) {
        while(A < B) {
            swap(nums, A, B);
            A++;
            B--;
        }
    }
    
    private void swap(int[] nums, int A, int B) {
        int tmp = nums[A];
        nums[A] = nums[B];
        nums[B] = tmp;
    }
}