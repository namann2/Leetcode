```
​
class Solution {
public int longestValidParentheses(String s) {
if(s==null || s.length()==0) return 0;
int n = s.length(), open = 0, close = 0, max = 0;
for(int i=0;i<n;i++) {
char ch = s.charAt(i);
if(ch == '(') open++;
else close++;
if(open == close) max = Math.max(max, open+close);
else if(close > open) open = close = 0;
}
open = close = 0;
for(int i=n-1;i>=0;i--) {
char ch = s.charAt(i);
if(ch==')') close++;
else open++;
if(open == close) max = Math.max(max, open+close);
else if(open > close) open = close = 0;
}