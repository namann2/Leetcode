class Solution {
    public String makeGood(String s) {
        int n = s.length(), i = 0;
        StringBuilder answer = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        while(i < n) {
            char ch = s.charAt(i);
            if(stack.isEmpty()) stack.addLast(ch);
            else if(!check(stack.peekLast(), ch)) stack.addLast(ch);
            else stack.removeLast();
            i++;
        }
        while(!stack.isEmpty())
            answer.append(stack.removeFirst());
        return answer.toString();
    }
    private boolean check(int A, int B) {
        return Math.abs(A - B) == 32;
    }
}