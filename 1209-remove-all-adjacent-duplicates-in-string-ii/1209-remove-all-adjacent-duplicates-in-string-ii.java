class Solution {
    public String removeDuplicates(String s, int k) {
        // TC : O(N)
        // SC : O(N)
        Stack<Pair> stack = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            // push current character
            if(stack.isEmpty() || stack.peek().ch != ch) 
                stack.push(new Pair(ch, 1));
            else {
                Pair top = stack.pop();
                top.cnt ++;
                stack.push(top);
            }
            // check if cnt of current char becomes k
            Pair top = stack.peek();
            if(top.cnt == k) stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            Pair top = stack.pop();
            while(top.cnt -- > 0)
                sb.append(top.ch);
        }
        
        return sb.reverse().toString();
    }
}

class Pair {
    char ch;
    int cnt;
    Pair(char ch, int cnt) {
        this.ch = ch;
        this.cnt = cnt;
    }
}