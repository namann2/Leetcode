class Solution {
    public boolean makeEqual(String[] words) {
        int[] cnt = new int[26];
        int twords = words.length;
        for(String word : words) {
            int n = word.length();
            for(int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                cnt[ch-'a']++;
            }
        }
        
        for(int i = 0; i < 26; i++) {
            if(cnt[i] % twords != 0) return false;
        }
        return true;
    }
}