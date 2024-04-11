class Solution {
    public int calculate(String s) {
        if(s==null || s.length() == 0)
            return 0;
        
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        char sign = '+';
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                int num = 0;
                while(i<n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i)-'0';
                    i++;
                }
                i--;
                updateStack(st, sign, num);
                sign = '+';
            }
            else if(ch == '(') {
                int j = i;
                int open = 0;
                while(j<n) {
                    if(s.charAt(j) == '(') open++;
                    else if(s.charAt(j) == ')') open--;
                    if(open == 0) break;
                    j++;
                }
                int num = calculate(s.substring(i+1, j));
                updateStack(st, sign, num);
                sign = '+';
                i = j;
            }
            else if(ch == ' ') continue;
            else sign = ch;
        }
        
        int res = 0;
        while(!st.isEmpty()) res += st.pop();
        return res;
    }
    private void updateStack(Stack<Integer> st, char sign, int num) {
        if(sign == '+') st.push(num);
        else if(sign == '-') st.push(-num);
        else if(sign == '*') st.push(st.pop() * num);
        else st.push(st.pop() / num);
    }
}