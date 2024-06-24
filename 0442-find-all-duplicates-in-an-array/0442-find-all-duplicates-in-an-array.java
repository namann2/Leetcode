class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;
        
        
        for(int i = 0; i < n; i++) {
            int element = Math.abs(nums[i]);
            int index = element - 1;
            if(nums[index] < 0) answer.add(element);
            else nums[index] *= -1;
        }
        return answer;
    }
}