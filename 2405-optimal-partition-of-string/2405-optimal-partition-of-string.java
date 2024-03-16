class Solution {
    public int partitionString(String s) {
        int mask = 0, cnt = 1;
        for(char ch : s.toCharArray()) {
            if(((mask >> (ch-'a')) & 1) == 1) {
                cnt++;
                mask = 0;
            }
            mask |= 1 << (ch-'a');
        }
        return cnt;
    }
}