class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, nums.length, new ArrayList<>(), result);
        return result;
    }

    private void subsets(int[] nums, int index, int n, List<Integer> temp, List<List<Integer>> result) {
        // base case
        result.add(new ArrayList<>(temp));
        // main logic
        for(int i = index; i < n; i++) {
            if(i > index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            subsets(nums, i+1, n, temp, result);
            temp.remove(temp.size()-1);
        }
    }
}