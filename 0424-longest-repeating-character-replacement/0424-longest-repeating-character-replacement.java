class Solution {
    public int characterReplacement(String s, int k) {
        // brute force : find every substring
        // int n = s.length();
        // int maxLength = 0;
        // for(int i = 0; i < n; i++) {
        //     int[] cnt = new int[26];
        //     int maxFreq = 0;
        //     for(int j = i; j < n; j++) {
        //         cnt[s.charAt(j)-'A']++;
        //         maxFreq = Math.max(maxFreq, cnt[s.charAt(j)-'A']);
        //         // we would want to convert other chars to that character which is more freq
        //         // to increase the length of longest required string
        //         int remain = j - i + 1 - maxFreq;
        //         if(remain <= k)
        //             maxLength = Math.max(maxLength, j - i + 1);
        //     }
        // }
        // return maxLength;
        
        int n = s.length(), maxLength = 0;
        int end = 0, begin = 0, maxFreq = 0;
        int[] cnt = new int[26];
        while(end < n) {
            char ch = s.charAt(end);
            cnt[ch-'A']++;
            maxFreq = Math.max(maxFreq, cnt[ch-'A']);
            int remain = end - begin + 1 - maxFreq;
            if(remain <= k) maxLength = Math.max(maxLength, end - begin + 1);
            else {
                char rm = s.charAt(begin);
                cnt[rm-'A']--;
                begin++;
            }
            end++;
        }
        return maxLength;
    }
}