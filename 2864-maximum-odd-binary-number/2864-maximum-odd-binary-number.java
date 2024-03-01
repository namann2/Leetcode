class Solution {
    public String maximumOddBinaryNumber(String s) {
        int setBits = 0;
        for(char ch : s.toCharArray())
            if(ch == '1') ++setBits;

        if(setBits == 0) return s;
        int n = s.length();
        char[] ch = new char[n];
        Arrays.fill(ch, '0');
        // last index will always be one to make the number as odd
        ch[n-1] = '1';
        // we have to make indices set to 1 starting from left, as power of 2 is maximum there, so as 
        // to maximise the result
        for(int i=0;i<n-1 && --setBits > 0;i++) {
            ch[i] = '1';
        }
        return new String(ch);
    }
}