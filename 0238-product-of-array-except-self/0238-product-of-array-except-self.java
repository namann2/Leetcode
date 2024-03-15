class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int left = 1, right = 1;
        answer[0] = 1;
        for(int i = 1; i < n; i++) {
            answer[i] = left * nums[i-1];
            left = answer[i];
        }
        for(int i = n-2; i >= 0; i--) {
            int temp = right * nums[i+1];
            answer[i] *= temp;
            right = temp;
        }
        return answer;
    }
}