class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<Integer>();
        Stack<Integer> star = new Stack<Integer>();
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                open.push(i);
            } else if(ch == '*') {
                star.push(i);
            } else {
                if(open.size() == 0 && star.size() == 0) {
                    return false;
                } else if(open.size() > 0) {
                    open.pop();
                } else if(star.size() > 0) {
                    star.pop();
                }
            }
        }
        
        if(open.size() == 0) return true;
        
        // check if we have to balance some ( with *
        while(open.size() > 0) {
            if(star.size() == 0) return false;
            else {
                if(open.peek() < star.peek()) {
                    open.pop();
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}