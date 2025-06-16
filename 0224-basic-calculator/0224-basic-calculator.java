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
        if(sign == 1) stack.push(number);
        else stack.push(-number);
    }
}