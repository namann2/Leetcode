class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for(String s : path.split("/")) {
            if(s.equals(".")) continue;
            else if(s.equals("..")) {
                if(!stack.isEmpty()) stack.removeLast();
                continue;
            }
            else if(s.length() == 0) continue;
            else stack.addLast(s);
        }
        
        if(stack.isEmpty()) return "/";
        
        StringBuilder p = new StringBuilder();
        while(!stack.isEmpty()) {
            p.append("/");
            p.append(stack.removeFirst());
        }
        return p.toString();
    }
}