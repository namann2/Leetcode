class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch))
                sb.append(Character.toLowerCase(ch));
        }
        
        return isPalindromeHelper(sb.toString());
    }
    
    private boolean isPalindromeHelper(String s) {
        int L = 0, R = s.length()-1;
        while(L <= R) {
            if(s.charAt(L++) != s.charAt(R--)) return false;
        }
        return true;
    }
}