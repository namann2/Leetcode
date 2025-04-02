https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution

```
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0)
            return result;
        
        bfs(s, result);
        return result;
    }
    private void bfs(String s, List<String> result) {
        
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        
        q.add(s);
        visited.add(s);
        boolean stop = false;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                String curr = q.poll();
                if(isValid(curr)) {
                    result.add(curr);
                    stop = true;
                }
                
                if(stop) continue; // as we dont want to remove any more parenthesis bcz we need to minimize the removals
                // check for every case
                for(int k = 0; k < curr.length(); k++) {
                    char ch = curr.charAt(k);
                    if(Character.isAlphabetic(ch)) 
                        continue;
                    
                    String newString = curr.substring(0, k) + curr.substring(k+1);
                    
                    if(!visited.contains(newString)) {
                        q.add(newString);
                        visited.add(newString);
                    }
                }
            }
        }
    }
    
    private boolean isValid(String curr) {
        int open = 0, close = 0;
        for(char ch : curr.toCharArray()) {
            if(ch == '(')
                open++;
            else if(ch == ')') {
                if(open > 0) open --;
                else close++;
            }
        }
        return open + close == 0;
    }
}
```
