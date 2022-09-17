class Solution {
    public int[] sumZero(int n) {
        int[]answer = new int[n];
        int val = 1, idx = 0;
        while(idx < n/2) {
            answer[idx] = val;
            answer[n-1-idx] = -val;
            val++;
            idx++;
        }
        return answer;
    }
}