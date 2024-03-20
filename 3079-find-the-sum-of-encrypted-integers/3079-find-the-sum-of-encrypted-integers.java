class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            int max = 0, cnt = 0;
            while(num > 0) {
                max = Math.max(max, num % 10);
                num /= 10;
                cnt++;
            }
            int nnum = 0;
            while(cnt > 0) {
                nnum = nnum * 10 + max;
                cnt--;
            }
            sum += nnum;
        }
        return sum;
    }
}