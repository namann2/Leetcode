class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        // constraint : if(n % 3 != 0) return new int[][]{};
        Arrays.sort(nums);
        int[][] result = new int[n / 3][];
        int j = 0;
        for(int i=0; i <= n-3; i+=3) {
            if(nums[i+2] - nums[i] <= k) {
                result[j++] = new int[]{nums[i], nums[i+1], nums[i+2]};
            }
            else return new int[][]{};
        }
        return result;
    }
}