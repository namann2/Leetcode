class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[]cnt = new int[101];
        int max = 0;
        for(int num : nums) {
            cnt[num]++;
            max = Math.max(max, cnt[num]);
        }
        int sum = 0;
        for(int freq : cnt)
            if(freq == max) sum += freq;
        return sum;
    }
}