class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int sum = Arrays.stream(matchsticks).sum();
        if(sum % 4 != 0) return false;
        return canMakeSquare(matchsticks, 0, new boolean[n], n, sum / 4, sum / 4, 4);
    }

    private boolean canMakeSquare(int[] nums, int index, boolean[] used, int n, int orgTarget, int target, int count) {
        // base case
        if(count == 0) return true;
        if(target == 0) {
            return canMakeSquare(nums, 0, used, n, orgTarget, orgTarget, count - 1);
        }
        if(target < 0 || index >= n) return false;
        // main logic
        for(int i = index; i < n; i++) {
            if(used[i] || target - nums[i] < 0) continue;
            used[i] = true;
            if(canMakeSquare(nums, i + 1, used, n, orgTarget, target - nums[i], count))
                return true;
            used[i] = false;
        }
        return false;
    }
}