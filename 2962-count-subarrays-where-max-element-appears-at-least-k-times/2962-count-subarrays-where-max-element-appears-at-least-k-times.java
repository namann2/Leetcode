class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0, cnt = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int begin = 0, end = 0, n = nums.length;
        while(end < n) {
            if(nums[end] == max) cnt++;
            while(cnt >= k && begin <= end) {
                ans += n - end;
                if(nums[begin] == max) cnt--;
                begin++;
            }
            end++;
        }
        return ans;
    }
}