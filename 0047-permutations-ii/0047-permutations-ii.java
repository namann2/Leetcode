class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> answer = new HashSet<>();
        int n = nums.length;
        int[] box = new int[n];
        Arrays.fill(box, -11);
        Arrays.sort(nums);
        permute(nums, 0, n, box, answer);
        return new ArrayList<>(answer);
    }
    private void permute(int[] nums, int index, int n, int[] box, HashSet<List<Integer>> answer) {
        // base case
        if(index == n) {
            List<Integer> temp = new ArrayList<>();
            for(int num : box) temp.add(num);
            answer.add(temp);
            return;
        }
        // main logic
        for(int i = 0; i<n; i++) {
            if(box[i] == -11) {
                box[i] = nums[index];
                permute(nums, index+1, n, box, answer);
                box[i] = -11;
            }
        }
    }
}