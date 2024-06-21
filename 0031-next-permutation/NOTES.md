Complete Solution with some comment :
```
class Solution {
public void nextPermutation(int[] A) {
// Check NOtes :
// TC : O(N)
// SC : O(1)
// 1,2,6,7,9,4,2,1
// 1,2,6,9,7,4,2,1
// 1,2,6,9,1,2,4,7
int position = -1;
int n = A.length;
for(int i=n-1;i>0;i--) {
if(A[i] > A[i-1]) {
position = i-1;
break;
}
}
if(position == -1) {
reverse(A, 0, n-1);
return;
}