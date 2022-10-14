class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];
        // get the frequency of all the characters
        for(char ch : s.toCharArray()) 
            count[ch-'a']++;

        int maxFreqCount = 0;
        char maxFreqChar = 'a';
        
        for(int i=0;i<26;i++) {
            char ch = (char)(i+'a');
            if(maxFreqCount < count[i]) {
                maxFreqChar = ch;
                maxFreqCount = count[i];
            }
        }
        // check if it is possible to reorganise the string
        if(maxFreqCount > (n+1)/2) 
            return "";
        
        char[] answer = new char[n];
        // fill in the maxFreqChar
        int idx = 0;
        while(maxFreqCount-- > 0) {
            answer[idx] = maxFreqChar;
            idx+=2;
        }
        
        count[maxFreqChar-'a'] = 0;
        
        // fill in the other characters
        for(int i=0;i<26;i++) {
            int freq = count[i];
            char ch = (char)(i+'a');
            while(freq-- > 0) {
                if(idx >= n) idx = 1;
                answer[idx] = ch;
                idx+=2;
            }
        }
        return String.valueOf(answer);
    }
}