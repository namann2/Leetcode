class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        long cnt = 0;
        int begin = 0, end = 0, n = nums.length, freq = 0;
        while(end < n) {
            if(nums[end] == max) freq++;
            while(freq >= k) {
                cnt += n - end;
                if(nums[begin] == max) freq--;
                begin++;
            }
            end++;
        }
        return cnt;
    }
}