class Solution {
    public long numberOfWays(String s) {
        // invalid cases : 000, 001, 011, 111, 100, 110
        // valid cases : 010, 101
        int n = s.length();
        int totalOnes = 0, totalZeros = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '0') totalZeros++;
            else totalOnes++;
        }
        
        int cnt0 = 0, cnt1 = 0;
        long ans = 0;
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(ch == '0') { // 101
                ans += cnt1 * (totalOnes - cnt1);
                cnt0++;
            } else { // 010
                ans += cnt0 * (totalZeros - cnt0);
                cnt1++;
            }
        }
        return ans;
    }
}