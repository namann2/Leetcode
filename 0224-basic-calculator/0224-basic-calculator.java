class Solution {
    public int calculate(String s) {
        Stack<int[]> stack = new Stack<>();
        int n = s.length(), result = 0;
        int sign = 1;
        for(int i = 0; i < n ;i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                int num = 0;
                while(i<n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                result += sign*num;
                sign = 1;
            } else if(ch == '(') {
                stack.push(new int[]{result, sign});
                result = 0;
                sign = 1;
            } else if(ch == ')') {
                result = stack.peek()[0] + stack.pop()[1] * result;
            } else if(ch == '+') {
                sign = 1;
            } else if(ch == '-') {
                sign = -1;
            } else continue;
        }
        return result;
    }
}