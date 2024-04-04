https://www.youtube.com/watch?v=LmHWIsBQBU4
​
# Naive Approach :
TC : `O(2^n-1 + n^2 + W)` where n-1 is the number of partitions we can make and n is the length of string & W is the number of words in the wordSet
```
class Solution {
public List<String> wordBreak(String s, List<String> wordDict) {
List<String> result = new ArrayList<>();
HashSet<String> wordSet = new HashSet<>(wordDict);
wordBreakUtil(s, wordSet,"", result);
return result;
}
private void wordBreakUtil(String s, HashSet<String> wordSet, String op, List<String> result) {
if(s.length() == 0) {
result.add(op.trim());
return;
}
int n = s.length();
for(int i=1;i<n;i++) {
String prefix = s.substring(0, i+1);
String suffix = s.substring(i+1);
if(wordSet.contains(prefix)) {
wordBreakUtil(suffix, wordSet, op+" "+prefix, result);