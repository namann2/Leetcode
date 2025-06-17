class Solution {
    public int calculate(String s) {
        int n = s.length();
        int result = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if(Character.isDigit(curr)) {
                int number = 0;
                // 23 / 4 - 4
                // r = 0, sign = +
                // S = 23
                while(i < n && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                switch(sign) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-number);
                        break;
                    case '/':
                        stack.push(stack.pop() / number);
                        break;
                    case '*':
                        stack.push(stack.pop() * number);
                        break;
                }
            } else if(isSymbol(curr)) sign = curr;
        }

        while(!stack.isEmpty()) result += stack.pop();
        return result;
    }

    // helper function
    private boolean isSymbol(char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '*';
    }
}