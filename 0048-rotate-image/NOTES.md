```
class Solution {
public void rotate(int[][] matrix) {
//transpose and swap columns
int n = matrix.length, m = matrix[0].length;
for(int i=0;i<n;i++) {
for(int j=0;j<m;j++) {
if(i>j) {
int t = matrix[i][j];
matrix[i][j] = matrix[j][i];
matrix[j][i] = t;
}
}
}
// swap
for(int j=0;j<m/2;j++) {
for(int i=0;i<n;i++) {
int t = matrix[i][j];
matrix[i][j] = matrix[i][m-j-1];
matrix[i][m-j-1] = t;
}
}
}
}
```