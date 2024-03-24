class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;
        
        Arrays.sort(nums);
        int[] lcs = new int[n];
        int answer = 1;
        lcs[n-1] = 1;
        for(int i=n-2;i>=0;i--) {
            if(nums[i] + 1 == nums[i+1]) lcs[i] = lcs[i+1] + 1;
            else if(nums[i] == nums[i+1]) lcs[i] = lcs[i+1];
            else lcs[i] = 1;
            answer = Math.max(answer, lcs[i]);
        }
        return answer;
    }
}