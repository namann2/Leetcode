https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution
​
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