class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<int[]> stack = new Stack<>();
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
                result += (sign * number);
                sign = 1;
            } else if(curr == '+') {
                sign = 1;
            } else if(curr == '-') {
                sign = -1;
            } else if(curr == '(') {
                updateStack(stack, result, sign);
                sign = 1;
                result = 0;
            } else if(curr == ')') {
                result = stack.peek()[0] + (stack.pop()[1] * result);
            }
        }
        return result;
    }

    // helper function
    private void updateStack(Stack<int[]> stack, int number, int sign) {
        stack.push(new int[]{number, sign});
    }
}