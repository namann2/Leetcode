```
class Solution {
public double findMedianSortedArrays(int[] A, int[] B) {
int n = A.length, m = B.length;
if(n>m) return findMedianSortedArrays(B, A);
int total = n+m;
int halfs = (total+1)/2;
/*
if total # of elements =
1. even eg : 10, each half will have 5 elements each
2. odd eg : 7,
I am assuming the answer should lie in the first half so,
I will take more # of elements in left half so, total+1 makes that
sure.
this change will not affect the even case
TC : O(log(min(n,m)))
as we are applying binarysearch on the array which has smaller length
*/
int start = 0, end = n; // why n ?