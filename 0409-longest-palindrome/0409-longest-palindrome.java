class Solution {
    public int longestPalindrome(String s) {
        int[]cnt = new int[52];
        int n = s.length();
        for(char ch : s.toCharArray()) {
            int idx = ch - 'A' - (ch >= 97 ? 6 : 0);
            cnt[idx] ++;
        }
        int odd = 0;
        for(int i = 0; i < 52;i++) {
            if(cnt[i] == 0) continue;
            if(cnt[i] % 2 == 1) odd++; 
        }
        
        return n - odd + (odd > 0 ? 1 : 0);
    }
}