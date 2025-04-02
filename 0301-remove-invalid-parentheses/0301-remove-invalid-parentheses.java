class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> answer = new ArrayList<>();
        removeInvalidParenthesis(s, answer);
        return answer;
    }

    private void removeInvalidParenthesis(String s, List<String> answer) {
        int n = s.length();
        Queue<String> q = new LinkedList<>();

        q.offer(s);
        Set<String> visited = new HashSet<>();
        boolean found = false;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String curr = q.poll();
                // early break
                if(isValid(curr)) {
                    answer.add(curr);
                    found = true;
                }
                if(found) break;
                int currLength = curr.length();
                for(int j = 0; j < currLength; j++) {
                    char ch = curr.charAt(j);
                    if(Character.isAlphabetic(ch)) continue;
                    String newString = curr.substring(0, j) + curr.substring(j+1);
                    if(visited.add(newString))
                        q.offer(newString);
                }
            }
        }
    }

    private boolean isValid(String s) {
        int open = 0, close = 0, n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch)) continue;
            if(ch == '(') open++;
            else {
                if(open > 0) open--;
                else close++;
            }
        }
        return open + close == 0;
    }
}