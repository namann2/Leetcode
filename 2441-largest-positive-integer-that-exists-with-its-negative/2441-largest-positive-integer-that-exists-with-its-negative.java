class Solution {
    public int findMaxK(int[] nums) {
        int b = 1000, max = -1;
        boolean[] A = new boolean[2001];
        for(int num : nums)
            A[b + num] = true; 
        for(int num : nums)
            if(A[b - num]) 
                max = Math.max(max, num);
        return max;
    }
}