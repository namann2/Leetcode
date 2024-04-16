class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length-1, answer = -1;
        while(left < right) {
            int currSum = nums[left] + nums[right];
            if(currSum < k) {
                answer = Math.max(answer, currSum);
                left ++;
            } else right--;
        }
        return answer;
    }
}