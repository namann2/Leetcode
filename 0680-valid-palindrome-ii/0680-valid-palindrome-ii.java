class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int L = 0, R = n-1;
        while(L <= R) {
            if(s.charAt(L) == s.charAt(R)) {
                L++;
                R--;
            } else {
                return isPalindrome(s, L + 1, R) || isPalindrome(s, L, R - 1);
            }
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int L, int R) {
        while(L <= R)
            if(s.charAt(L++) != s.charAt(R--)) return false;
        return true;
    }
}