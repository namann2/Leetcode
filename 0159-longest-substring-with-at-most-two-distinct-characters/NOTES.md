```
class Solution {
public int lengthOfLongestSubstringTwoDistinct(String s) {
int begin = 0, end = 0, len = 0, n = s.length();
HashMap<Character, Integer> map = new HashMap<>();
while(end<n) {
char ch = s.charAt(end);
map.put(ch, map.getOrDefault(ch, 0)+1);
// at most 2 distinct chars
if(map.size() <= 2) {
len = Math.max(len, end-begin+1);
}
// if chars are more then 2, keep on removing until we find
else if(map.size() > 2) {
while(map.size() > 2) {
char rm = s.charAt(begin);
map.put(rm, map.get(rm)-1);
if(map.get(rm) == 0) map.remove(rm);
begin++;
}
}
end++;
}
return len;
}