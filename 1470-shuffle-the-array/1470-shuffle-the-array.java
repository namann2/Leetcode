class Solution {
    public int[] shuffle(int[] nums, int n) {
        int m = 2 * n;
        int[] answer = new int[m];
        int i = 0, j = n, pos = 0;
        while(pos < m) {
            answer[pos++] = nums[i++];
            answer[pos++] = nums[j++];
        }
        return answer;
    }
}