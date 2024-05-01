class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '*')
                stack.removeLast();
            else stack.addLast(ch);
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty())
            ans.append(stack.removeFirst());
        return ans.toString();
    }
}