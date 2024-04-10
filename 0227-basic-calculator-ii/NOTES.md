```
class Solution {
public int calculate(String s) {
if(s == null || s.equals(" ")) return 0;
int n = s.length();
int result = 0;
char sign = '+';
Stack<Integer> stack = new Stack<>();
​
for(int i=0;i<n;i++) {
char ch = s.charAt(i);
if(Character.isDigit(ch)) {
int num = 0;
while(i<n && Character.isDigit(s.charAt(i))) {
num = num * 10 + s.charAt(i)-'0';
i++;
}
i--;
switch(sign) {
case '+':
stack.push(num);
break;
case '-':
stack.push(-num);
break;
case '*':
stack.push(stack.pop() * num);
break;
case '/':
stack.push(stack.pop() / num);
break;
}
sign = '+';
}
else if(ch == ' ') continue;
else sign = ch;
}
while(!stack.isEmpty())
result += stack.pop();
return result;
}
}
```