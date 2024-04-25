## Nice / Optimal Approach :
​
```
class Solution {
public int longestIdealString(String s, int k) {
int n = s.length();
int[]dp = new int[26];
int maxLength = 0;
for(int i = 0; i < n ; i++) {
int ch = s.charAt(i) - 'a';
for(int j = Math.max(0, ch - k); j <= Math.min(25, ch + k); j++) {
dp[ch] = Math.max(dp[ch], dp[j]);
}
dp[ch] ++;
maxLength = Math.max(maxLength, dp[ch]);
}
return maxLength;
}
}
```