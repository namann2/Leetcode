class Solution {
    private static final int BASE = -11;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        int n = nums.length;
        int[] buckets = new int[n];
        Arrays.fill(buckets, BASE);
        permute(nums, 0, n, buckets, permutations);
        return permutations;
    }
    
    private void permute(int[] nums, int index, int n, int[] buckets, List<List<Integer>> permutations) {
        // base case
        if(index == n) {
            permutations.add(Arrays.stream(buckets).boxed().collect(Collectors.toList()));
            // List<Integer> currPermutations = new ArrayList<>();
            // for(int num : buckets) 
            //     currPermutations.add(num);
            // permutations.add(currPermutations);
            return;
        }
        // main logic
        for(int i = 0; i < n; i++) {
            if(buckets[i] == BASE) {
                buckets[i] = nums[index];
                permute(nums, index + 1, n, buckets, permutations);
                buckets[i] = BASE;
            }
        }
    }
}