class Solution {
    public char repeatedCharacter(String s) {
        int mask = 0, n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int shift = ch - 'a';
            if((1 & (mask >> shift)) == 1) return ch;
            mask |= (1 << shift);
        }
        return 'a';
    }
}