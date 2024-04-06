int position = -1;
// find the position that needs to be changed for the next permutation
for(int i=A.length-1;i>0;i--) {
if(A[i] > A[i-1]) {
position = i-1;
break;
}
}
if(position == -1) {
// we are already at the greatest permutation
reverse(A, 0, A.length-1);
} else {
// we have position, but we need the element that can be placed at this location
int num_i = -1;
for(int i=position+1;i<A.length;i++) {
if(A[position] < A[i]) num_i = i;
}
int temp = A[position];
A[position] = A[num_i];
A[num_i] = temp;
reverse(A, position+1, A.length-1);
}
}
private void reverse(int[] A, int L, int R) {
while(L<R) {
int t = A[L];
A[L] = A[R];
A[R] = t;
R--;
L++;
}
}
}
```
​
______________
​
```
Next Permutation :
​
We are talking about the next permutation i.e. the next greater number that can be formed from the set of numbers we are given.
​
[1,2,3] -> [1,3,2]
[5,4,3,2,1] -> [1,2,3,4,5]