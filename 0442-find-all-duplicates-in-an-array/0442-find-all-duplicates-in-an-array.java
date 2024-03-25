class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length, i = 0;
        while(i < n) {
            int correctIndex = nums[i]-1;
            if(nums[correctIndex] == nums[i]) {
                i++;
                continue;
            }
            int tmp = nums[i];
            nums[i] = nums[correctIndex];
            nums[correctIndex] = tmp;
        }
        
        i=0;
        while(i < n) {
            if(i+1 != nums[i]) {
                answer.add(nums[i]);
            }
            i++;
        }
        return answer;
    }
}