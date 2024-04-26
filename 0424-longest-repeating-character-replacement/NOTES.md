### Naive Approach :
​
```
​
class Solution {
public int characterReplacement(String s, int k) {
int n = s.length();
int maxLength = 0;
for(int i = 0; i < n; i++) {
int[] cnt = new int[26];
int maxFreq = 0;
for(int j = i; j < n; j++) {
cnt[s.charAt(j)-'A']++;
maxFreq = Math.max(maxFreq, cnt[s.charAt(j)-'A']);
int remain = j - i + 1 - maxFreq;
if(remain <= k)
maxLength = Math.max(maxLength, j - i + 1);
}
}
return maxLength;
}
}
```