class Solution {
    public boolean checkIfPangram(String sentence) {
        int ok = 0;
        for(char ch : sentence.toCharArray()) {
            int currBit = (ch - 'a');
            ok |= (1 << currBit);
        }
        
        for(int i=0;i<26;i++)
            if(((ok >> i) & 1) != 1) return false;
        return true;
    }
}