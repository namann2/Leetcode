class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        int i = 0, ans = 0;
        
        Arrays.sort(nums);
        
        while(i < n) {
            int j = i + 1, k = n - 1;
            while(j < k) {
                int csum = nums[i] + nums[j] + nums[k];
                if(csum >= target) k--;
                else {
                    // . . . . . .
                    // i.  j.  k
                    // 0 1 2 3 4 5
                    ans += k - j; // pair of i and k with different j -> [i, j, k], [i,j+1,k]...for j < k
                    j++;
                }
            }
            i++;
        }
        return ans;
    }
}