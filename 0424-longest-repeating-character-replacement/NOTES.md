## Naive / Brute Force Solution : 
```
class Solution {
    public int characterReplacement(String s, int k) {
        // brute force : find every substring
        int n = s.length();
        int maxLength = 0;
        for(int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for(int j = i; j < n; j++) {
                cnt[s.charAt(j)-'A']++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j)-'A']);
                // we would want to convert other chars to that character which is more freq
                // to increase the length of longest required string
                int remain = j - i + 1 - maxFreq;
                if(remain <= k)
                    maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
}
```

## Sliding Window - Optimal - Based on top of Brute Force

⭐⭐⭐⭐⭐⭐⭐⭐
So, we can say if we want to find the longest or maximum with a condition limited by atmost k then using an if condiftion makes more sense always due to the following :

1. a while loop would potentially shrinking the window by many positions in a single iteration of the outer loop.
2. Since we only care about the max length, any smaller window within it would become irrelevant


Clarifying Question ?
1. Why did we not update the maxFreq while shrinking the window ?
   > If maxFrequ drops while we shrink the window, the maximum possible valid window size we can achieve right now also drops. We don't care about smaller windows because they can never beat our recorded maxLength. 
```
class Solution {
    public int characterReplacement(String s, int k) {
        int begin = 0, end = 0, n = s.length();
        int maxFreq = 0, answer = 0;
        int[] freq = new int[26];
        while(end < n) {
            char ch = s.charAt(end);
            maxFreq = Math.max(maxFreq, ++freq[ch - 'A']);
            int remainingChars = end - begin + 1 - maxFreq;
            // can the remaining chars be converted to the maxFrequency character
            if(remainingChars <= k) {
                answer = Math.max(answer, end - begin + 1);
            } else {
                char rm = s.charAt(begin++);
                freq[rm - 'A']--;
            }
            end++;
        }
        return answer;
    }
}
```
