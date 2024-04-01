class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int ptr = n-1;
        while(ptr >= 0 && s.charAt(ptr) == ' ') ptr--;
        
        int length = 0;
        while(ptr >= 0 && s.charAt(ptr) != ' ') {
            ptr--;
            length++;
        }
        return length;
    }
}