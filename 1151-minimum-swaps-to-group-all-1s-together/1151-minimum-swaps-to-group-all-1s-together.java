class Solution {
    public int minSwaps(int[] data) {
        int cnt = Arrays.stream(data).sum(), n = data.length;
        int end = 0, begin = 0, k = cnt, maxOnes = 0;
        cnt = 0;
        while(end < n) {
            cnt += data[end];
            while(end-begin+1 > k) {
                if(data[begin++] == 1) cnt--;
            }
            if(end-begin+1 == k)
                maxOnes = Math.max(maxOnes, cnt);
            end++;
        }
        return k - maxOnes;
    }
}