class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int n = nums.length;
        int[] nextRow = new int[n + 1];
        for(int i = 0; i < n; i++) {
            int row = nextRow[nums[i]];
            if(row >= answer.size()) answer.add(new ArrayList<>());
            answer.get(row).add(nums[i]);
            nextRow[nums[i]]++;
        }
        return answer;
    }
}