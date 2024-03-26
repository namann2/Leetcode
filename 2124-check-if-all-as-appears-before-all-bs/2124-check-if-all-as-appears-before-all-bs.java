class Solution {
    public boolean checkString(String s) {
        int a = 0, b = 0;
        for(char ch : s.toCharArray()) {
            if(ch == 'b') b++;
            else {
                a++;
                if(b > 0) return false;
            }
        }
        return true;
    }
}