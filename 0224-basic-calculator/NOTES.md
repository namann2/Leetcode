#### Approach 1 : For Calculator 1/2/3

This TEMPLATE works for basic calculator 1, however CAN be highly optimised.
```
class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int result = 0, sign = 1;
        for(int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            // get number and push to stack after updating with sign
            if(Character.isDigit(curr)) {
                int number = 0;
                while(i < n && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                updateStack(stack, number, sign);
                sign = 1;
            } else if(curr == '+') {
                sign = 1;
            } else if(curr == '-') {
                sign = -1;
            } else if(curr == '(') {
                // find the corresponding closing paranthesis
                int cursor = i, open = 0, close = 0;
                while(cursor < n) {
                    if(s.charAt(cursor) == '(') open++;
                    else if(s.charAt(cursor) == ')') close++;
                    if(open == close) break;
                    cursor++;
                }
                int number = calculate(s.substring(i+1, cursor));
                updateStack(stack, number, sign);
                sign = 1;
                i = cursor;
            }
        }

        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    // helper function
    private void updateStack(Stack<Integer> stack, int number, int sign) {
        stack.push(sign * number);
    }
}
```

<br>

#### Approach 2 : Better
```
class Solution {
    public int calculate(String s) {
        if(s==null || s.length() == 0 || s.equals(" ")) return 0;
        if(s.length() == 1 && !s.equals(" ")) return s.charAt(0)-'0';
        
        int n = s.length();
        int sign = +1;
        
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                int num = 0;
                while(i<n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                result += (sign)*num;
                sign = +1;
            }
            else if(ch == '(') {
                stack.push(new int[]{result, sign});
                result = 0;
                sign = +1;
            }
            else if(ch == ')') {
                result = stack.peek()[0] + stack.pop()[1] * result;
            }
            else if(ch == '+') {
                sign = +1;
            }
            else if(ch == '-') {
                sign = -1;
            }
            else if(ch == ' ') continue;
        }
        return result;
    }
}

```​
