class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length, l = 0, r = n-1, idx = n-1;
        int ans[] = new int[n];
        // start filling from one side 
        // to make sure the pos of sq are correct. Which side ? Which side do you think we can
        // be 100% sure that can be filled while comparing two number ? The greater side since we
        // can have neg values, and there positions can not be determined because we need to compare
        // them will smaller positive numbers.
        while(l <= r) {
            int ns = nums[l] * nums[l];
            int ps = nums[r] * nums[r];
            if(ns <= ps) {
                ans[idx--] = ps;
                r--;
            } else {
                ans[idx--] = ns;
                l++;
            }
        }
        return ans;
    }
}
