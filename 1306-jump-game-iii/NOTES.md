# Solution 1 : Using BFS
​
```
​
class Solution {
public boolean canReach(int[] A, int start) {
if(A[start] == 0)
return true;
int n = A.length;
Queue<Integer> q = new LinkedList<>();
q.add(start);
HashSet<Integer> vis = new HashSet<>();
vis.add(start);
while(!q.isEmpty()) {
int curr = q.poll();
if(A[curr] == 0) return true;
int fwd = curr + A[curr];
int bck = curr - A[curr];
if(fwd < n && vis.add(fwd)) q.add(fwd);
if(bck >= 0 && vis.add(bck)) q.add(bck);
}
return false;
}