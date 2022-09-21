class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0, n = nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i] % 2 == 0) sum += nums[i];
        }
        
        int[]res = new int[n];
        int idx = 0;
        for(int [] q : queries) {
            int index = q[1];
            int val = q[0];
            if(nums[index] % 2 == 0) sum -= nums[index];
            nums[index] += val;
            if(nums[index] % 2 == 0) sum += nums[index];
            
            res[idx++] = sum;
        }
        return res;
    }
}