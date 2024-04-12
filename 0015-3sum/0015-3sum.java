class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        Set<Integer> starts = new HashSet<>();
        // required sum with i as starting point of the triplet, 
        // to keep a check that the triplet we are formulating
        // starts with index >= i
        Map<Integer,Integer> requiredSumWithI = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(starts.add(nums[i])) {
                for(int j = i + 1; j < n; j++) {
                    int third = -(nums[i] + nums[j]);
                    if(requiredSumWithI.containsKey(third) && requiredSumWithI.get(third) >= i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                        Collections.sort(triplet);
                        ans.add(triplet);
                    }
                    requiredSumWithI.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
