class Solution {
    public long countVowels(String word) {
        long ans = 0;
        int n = word.length();
        for(int i=0;i<n;i++) {
            char ch = word.charAt(i);
            ans += isVowel(ch) ? 1L * (i+1) * (n-i) : 0;
        }
        return ans;
    }
    private boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }
}