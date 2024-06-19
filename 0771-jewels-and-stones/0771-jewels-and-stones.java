class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] jewelsCharacter = new boolean[52];
        int jewelsLength = jewels.length();
        for(int i = 0; i < jewelsLength; i++) {
            char ch = jewels.charAt(i);
            if(ch >= 'a' && ch <= 'z')
                jewelsCharacter[ch - 'a'] = true;
            else jewelsCharacter[ch - 'A' + 26] = true;
        }
        
        int jewelStones = 0, stonesLength = stones.length();
        for(int i = 0; i < stonesLength; i++) {
            char ch = stones.charAt(i);
            if(ch >= 'a' && ch <= 'z') 
                jewelStones += jewelsCharacter[ch - 'a'] == true ? 1 : 0;
            else jewelStones += jewelsCharacter[ch - 'A' + 26] == true ? 1 : 0;
        }
        return jewelStones;
    }
}