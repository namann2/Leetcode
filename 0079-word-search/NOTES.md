# Indeed Q :
Find the coordinates of cells that match a word :
```
class Solution {
ArrayList<int[]> ans;
public boolean exist(char[][] board, String word) {
if(board == null || board.length == 0)
return false;
int rows = board.length, cols = board[0].length;
boolean res = false;
ans = new ArrayList<>();
for(int i=0;i<rows;i++) {
for(int j=0;j<cols;j++) {
if(board[i][j] == word.charAt(0)) {
if(dfs(board, i, j, rows, cols, 0, word))
{
res = true;
break;
}
}
}
}
int l = ans.size();
System.out.println("------"); // going from back to front as we add coordinates while backtracking
for(int i=l-1;i>=0;i--) {
int[]d = ans.get(i);