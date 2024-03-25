READ THIS FIRST BEFORE TRYING THE QUESTION
In a grid, if we need to find the path from one source to a destination then we have to options :
1. BFS ( **We need an early break condition here** )
2. A* Algorithm ( extension to djikstra's - used by google maps )
​
​
# : 1
```
class Solution {
public int shortestPathBinaryMatrix(int[][] grid) {
int rows = grid.length, cols = grid[0].length;
if(grid[0][0] == 1 || grid[rows-1][cols-1] == 1)
return -1;
Queue<int[]> q = new LinkedList<>();
HashSet<String> visited = new HashSet<>();
q.add(new int[]{0,0});
visited.add(0+"-"+0);
int dis = 0;
int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
int[] dy = {-1, 1, 0, 0, 1, -1, -1, 1};
while(!q.isEmpty()) {
int size = q.size();
for(int i=0;i<size;i++) {
int[] currCell = q.poll();
if(currCell[0] == rows-1 && currCell[1] == cols-1)