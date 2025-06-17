class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        char sign = '+';
        for(int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if(Character.isDigit(curr)) {
                int number = 0;
                while(i < n && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                updateStack(stack, number, sign);
                sign = '+';
            } else if(isSymbol(curr)) {
                sign = curr;
            } else if(curr == '(') {
                int cursor = i, open = 0, close = 0;
                while(cursor < n) {
                    if(s.charAt(cursor) == '(') open++;
                    else if(s.charAt(cursor) == ')') close++;
                    if(open == close) break;
                    cursor++;
                }
                // TODO : handle the return code
                int subResult = calculate(s.substring(i+1, cursor));
                updateStack(stack, subResult, sign);
                i = cursor;
                sign = '+';
            } else if(curr == ')') {
                break;
            }
        }

        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    // helper function
    private boolean isSymbol(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private void updateStack(Stack<Integer> stack, int number, char sign) {
        switch(sign) {
            case '+': 
                stack.push(number);
                break;
            case '-':
                stack.push(-number);
                break;
            case '*':
                stack.push(stack.pop() * number);
                break;
            case '/':
                stack.push(stack.pop() / number);
                break;
        }
    }
}