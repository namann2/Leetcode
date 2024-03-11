// Solution 1 :
TC : O(S.length() + O.length())
SC : O(26)
​
```
class Solution {
public String customSortString(String order, String str) {
// maintain the count of all the characters in given str
int[] count = new int[26];
for(int i=0;i<str.length();i++) {
count[str.charAt(i)-'a']++;
}
// now we want to maintain the order of given string, acc to the given order
StringBuilder s = new StringBuilder();
for(int i=0;i<order.length();i++) {
while(count[order.charAt(i)-'a']-- > 0) s.append(order.charAt(i));
}
// add up all the remaining chars
for(int i=0;i<26;i++) {
while(count[i]-- > 0) s.append((char)(i+'a'));
}
return s.toString();
}