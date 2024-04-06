https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/1850228/Java-4-Solutions-with-slight-optimisations
​
```
class Solution {
public String minRemoveToMakeValid(String s) {
Deque<Integer> stack = new ArrayDeque<>();
int n = s.length();
char[]ch = s.toCharArray();
for(int i=0;i<n;i++) {
char c = ch[i];
if(c == '(')
stack.push(i);
else if(c == ')') {
if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') stack.pop();
else ch[i] = '#';
}
}
while(!stack.isEmpty()) {
ch[stack.pop()] = '#';
}
StringBuilder sb = new StringBuilder();
for(int i=0;i<ch.length;i++)