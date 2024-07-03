### Solution 1 :
​
Scope of improvement :
1. Better way to verify if one word is a predecessor of another
2. TC : O(nlogn + n * n * L), where L is the average length of word
3. SC : O(n)
​
```
class Solution {
public int longestStrChain(String[] words) {
int n = words.length;
// sort the words by length
Arrays.sort(words, (w1, w2) -> {
return w1.length() - w2.length();
});
// this seems like an application of LIS
int[] dp = new int[n + 1];
int maxLength = 0;
for(int i = 0; i < n; i++) {
dp[i] = 1;
for(int j = 0; j < i; j++) {
if(isPredecessor(words[j], words[i]) && 1 + dp[j] > dp[i]) {
dp[i] = 1 + dp[j];
}
}
maxLength = Math.max(maxLength, dp[i]);
}
return maxLength;
}
```