```
class Solution {
public String minWindow(String s, String t) {
// base cases
if(s.equals(t))
return s;
if(t.length() > s.length()) return "";
HashMap<Character, Integer> s_map = new HashMap<>();
HashMap<Character, Integer> t_map = new HashMap<>();
for(char ch : t.toCharArray())
t_map.put(ch, t_map.getOrDefault(ch, 0)+1);
int begin = 0, end = 0, n = s.length(), minWindow = Integer.MAX_VALUE;
int matchedCount = 0, needCount = t.length();
// matchedCount tells number of chars matched in both s and t
// needCount tells number of chars we need to be matched = t.length()
String minWindowSubstr = "";
while(end < n) {
char ch = s.charAt(end);
s_map.put(ch, s_map.getOrDefault(ch, 0)+1);
// can we acquire this particular char
if(t_map.containsKey(ch) && t_map.get(ch) >= s_map.get(ch)) matchedCount++;
while(matchedCount == needCount) {
if(minWindow > end - begin + 1) {