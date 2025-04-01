class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, n, new ArrayList<>(), answer);
        return answer;
    }

    private void subsets(int[] nums, int index, int n, List<Integer> temp, List<List<Integer>> answer) {

        answer.add(new ArrayList<>(temp));
        
        // main logic
        for(int i = index; i < n; i++) {
            if(i > index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            subsets(nums, i + 1, n, temp, answer);
            temp.remove(temp.size()-1);
        }
    }
}