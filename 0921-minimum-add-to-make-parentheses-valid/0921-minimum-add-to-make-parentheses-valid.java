class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        // for(int i = 0; i < n; i++) {
        //     char ch = s.charAt(i);
        //     if(ch == '(') stack.addLast(ch);
        //     else if(ch == ')' && !stack.isEmpty() && stack.peekLast() == '(') stack.removeLast();
        //     else stack.addLast(ch);
        // }
        // return stack.size();
        
        int open = 0, close = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else if(ch == ')' && open > 0) open--;
            else close ++;
        }
        return open + close;
    }
}