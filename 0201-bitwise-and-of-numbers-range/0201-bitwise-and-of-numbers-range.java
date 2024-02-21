class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int answer = 0;
        for(int i=30;i>=0;i--) {
            int bit1 = (left >> i) & 1;
            int bit2 = (right >> i) & 1;
            if(bit1 == bit2) {
                if(bit1 == 1) answer |= (1 << i);
            }
            else break;
        }
        return answer;
    }
}
