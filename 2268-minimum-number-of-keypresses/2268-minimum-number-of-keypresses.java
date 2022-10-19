class Solution {
    public int minimumKeypresses(String s) {
        Integer[]count = new Integer[26];
        Arrays.fill(count, 0);
        
        for(char ch : s.toCharArray())
            count[ch-'a']++;
        
        Arrays.sort(count, (a, b) -> {
            return b - a;
        });
        
        int keypress = 0;
        for(int i=0;i<26;i++) {
            if(i < 9) keypress += count[i];
            else if(i >= 9 && i < 18) keypress += count[i] * 2;
            else keypress += count[i] * 3;
        }
        return keypress;
    }
}