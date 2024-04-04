# ✔ Solution 1: Backtracking Solution
Check every prefix of the string
```
class Solution {
public boolean wordBreak(String s, List<String> wordDict) {
HashSet<String> dict = new HashSet<>(wordDict);
return wordBreakUtil(s, dict);
}
private boolean wordBreakUtil(String s, HashSet<String> dict) {
// base case
if(s.length() == 0)
return true; // represent that we do not pick anything from the given list
// main logic
for(int i=0;i<s.length();i++) {
String prefix = s.substring(0, i+1);
String suffix = s.substring(i+1);
if(dict.contains(prefix) && wordBreakUtil(suffix, dict)) {
return true;
}
}
return false;
}
}
```