class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0)  // it is not possible to divide the entire array in k subportions
            return false;
        // ques : do we need exactly k subsets -> yes
        int required = sum / k;
        for(int num : nums) 
            if(num > required) return false;

        // doesn't determining above conditions allows us to conclude paritioning ?
        // No, above conditions concluded that it is possible to break given input into k subportions
        // but, whether the sum of all those paritions are equal or not isn't sure.
        int n = nums.length;
        Arrays.sort(nums);
        return canPartition(nums, 0, n, required, required, k, new boolean[n]);
    }

    private boolean canPartition(int[] nums, int index, int n, int orgTarget, int target, int count, boolean[] used) {
        // base case
        if(count == 0) return true;
        if(target == 0) return canPartition(nums, 0, n, orgTarget, orgTarget, count - 1, used);
        if(target < 0) return false;
        // main logic
        for(int i = index; i < n; i++) {
            if(used[i]) continue;
            used[i] = true;
            if(canPartition(nums, i + 1, n, orgTarget, target - nums[i], count, used))
                return true;
            used[i] = false;
        }
        return false;
    }
}