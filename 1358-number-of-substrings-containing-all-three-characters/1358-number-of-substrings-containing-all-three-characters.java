class Solution {
    public int numberOfSubstrings(String s) {
        // consider abc as x, and find the number of substrings ending at i ( starting from 0 to n) or
        // number of substrings starting from i ( from n to 0 )
        int n = s.length(), ans = 0;
        int a = -1, b = -1, c = -1;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == 'a') a = i;
            else if(ch == 'b') b = i;
            else c = i;
            if(a == -1 || b == -1 || c == -1) continue;
            int min = Math.min(a, Math.min(b, c));
            ans += min + 1;
        }
        return ans;
    }
}