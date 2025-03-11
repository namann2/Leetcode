class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, nums.length, new ArrayList<>(), result);
        return result;
    }

    private void subsets(int[] nums, int index, int n, List<Integer> temp, List<List<Integer>> result) {
        // base case
        if(index == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // main logic
        subsets(nums, index + 1, n, temp, result);
        
        temp.add(nums[index]);
        subsets(nums, index + 1, n, temp, result);
        temp.remove(temp.size()-1);
    }
}