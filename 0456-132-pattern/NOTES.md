1st solution :
Three nested loops :
​
​
2nd solution :
​
```
class Solution {
public boolean find132pattern(int[] A) {
int n = A.length;
// i < j < k => A[i] < A[k] < A[j]
int min = Integer.MAX_VALUE;
for(int j=0;j<n;j++) {
min = Math.min(min, A[j]); // A[i]
if(A[j] == min) // as A[i] < A[j] (strictly less)
continue;
for(int k=j+1;k<n;k++) {
if(A[k] < A[j] && min < A[k])
return true;
}
}
return false;
}
}
```