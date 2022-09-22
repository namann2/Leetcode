class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        for(int i=0;i<n;i++) {
            if(ch[i] != ' ') {
                int j=i;
                while(j<n && ch[j] != ' ') j++;
                reverse(ch, i, j-1);
                i = j;
            }
        }
        return String.valueOf(ch);
    }
    private void reverse(char[]ch, int i, int j) {
        while(i < j) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
            i++;
            j--;
        }
    }
}