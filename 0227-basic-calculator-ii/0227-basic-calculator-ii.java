class Solution {
    public int calculate(String s) {
        // convert to postfix and then solve
        Deque<Integer> stack = new ArrayDeque<>();
        int n = s.length(), ans = 0;
        char sign = '+';
        for(int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if(Character.isDigit(curr)) {
                int num = 0;
                while(i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                updateStack(stack, num, sign);
                i--;
                sign = '+';
            } else if(curr == ' ') continue;
            else sign = curr;
        }
        while(!stack.isEmpty()) {
            ans += stack.removeLast();
        }
        return ans;
    }
    private void updateStack(Deque<Integer> stack, int num, char sign) {
        if(sign == '*') stack.addLast(stack.removeLast() * num);
        else if(sign == '/') stack.addLast(stack.removeLast() / num);
        else if(sign == '+') stack.addLast(num);
        else stack.addLast(-num);
    }
}