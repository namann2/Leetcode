class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        
        // SC : O(Summation(n * max_nesting_level ^ nesting_level))
        // TC : O(n * max_nesting_level ^ nesting_level)
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == ']') {
                while(!stack.isEmpty() && stack.peekLast() != '[') {
                    word.append(stack.removeLast());
                }
                stack.removeLast();
                int x = 1, num = 0, len = word.length();
                while(!stack.isEmpty() && Character.isDigit(stack.peekLast())) {
                    num = (stack.removeLast() - '0') * x + num;
                    x *= 10;
                }
                while(num-- > 0) {
                    for(int k = len-1; k >= 0; k--) 
                        stack.addLast(word.charAt(k));
                }
                word.setLength(0);
            } else stack.addLast(ch);
        }
        
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append(stack.removeFirst());
        }
        return ans.toString();
    }
} 

// 123