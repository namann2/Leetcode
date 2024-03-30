class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int cnt_k = atmost(nums, k);
        int cnt_k_1 = atmost(nums, k-1);
        return cnt_k - cnt_k_1;
    }
    private int atmost(int[] nums, int k) {
        int n = nums.length, end = 0, begin = 0;
        Map<Integer, Integer> uniques = new HashMap<>();
        int cnt = 0;
        while(end < n) {
            uniques.put(nums[end], uniques.getOrDefault(nums[end], 0) + 1);
            while(uniques.size() > k && begin < end) {
                int curr = uniques.get(nums[begin]);
                if(curr - 1 > 0)
                    uniques.put(nums[begin], curr-1);
                else uniques.remove(nums[begin]);
                begin++;
            }
            if(uniques.size() <= k) {
                cnt += end - begin + 1;
            }
            end++;
        }
        return cnt;
    }
}