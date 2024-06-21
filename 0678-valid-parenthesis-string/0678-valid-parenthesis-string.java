class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') stack.push(i);
            else if(ch == '*') star.push(i);
            else {
                if(stack.isEmpty() && star.isEmpty()) return false;
                else if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') stack.pop();
                else if(!star.isEmpty()) star.pop();
                else stack.push(i);
            }
        }
        
        if(stack.isEmpty()) return true;
        
        while(!stack.isEmpty()) {
            if(star.isEmpty()) return false;
            int parenthesis = stack.pop();
            int starpos = star.pop();
            if(parenthesis >= starpos) return false;
        }
        
        return stack.isEmpty();
    }
}