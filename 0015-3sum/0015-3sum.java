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
            // check if unique start point
            if(starts.add(nums[i])) {
                for(int j = i + 1; j < n; j++) {
                    // the required number
                    int third = -(nums[i] + nums[j]);
                    if(requiredSumWithI.containsKey(third) && requiredSumWithI.get(third) >= i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                        // sorting a triplet 
                        Collections.sort(triplet);
                        ans.add(triplet);
                    }
                    // update the index of the number to check 
                    // if this can contribute for a triplet ahead
                    requiredSumWithI.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
