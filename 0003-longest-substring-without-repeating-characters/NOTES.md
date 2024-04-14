```
class Solution {
public int lengthOfLongestSubstring(String s) {
int begin = 0, end = 0, len = 0, n = s.length();
HashMap<Character, Integer> map = new HashMap<>();
while(end < n) {
char ch = s.charAt(end);
map.put(ch, map.getOrDefault(ch, 0)+1);
// check if no repeating chars
// i.e. window size equals map size
if(map.size() == end-begin+1) {
len = Math.max(len, end-begin+1);
}
else if(map.size() < end-begin+1) {
// remove the elements
while(map.size() < end-begin+1) {
char rm = s.charAt(begin);
map.put(rm, map.get(rm)-1);
// remove the char that does not have any occurence in the window
if(map.get(rm) == 0) map.remove(rm);
begin++;
}
}
end++;
}
return len;