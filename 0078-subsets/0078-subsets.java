class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), answer);
        return answer;
    }
    private void subsets(int[] nums, int index, List<Integer> temp, List<List<Integer>> answer) {
        // base case
        if(index == nums.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        
        // main logic
        temp.add(nums[index]);
        subsets(nums, index+1, temp, answer);
        temp.remove(temp.size()-1);
        
        subsets(nums, index+1, temp, answer);
    }
}