# IMPORTANT :
no need to look for any tutorial, just read through the explanation :
​
```
class Solution {
public int sumSubarrayMins(int[] A) {
// return the sum of minimums of all subarrays
// the O(n2) is intuitive - We can use gap method ,
// but how can we reduce it to O(n)
/*
We will have to count those subarrays in which A[i] is the minimum.
- On the left  ( ending at A[i] )
- On the right ( starting at A[i] )
It is because, we are aiming to find the number of subarrays to the left, in which A[i] will be the
smallest. and same for the right hand side.
index = [0, 1, 2, 3]
A =     [3, 1, 2, 4]
left =  [1, 2, 1, 1]
right=  [1, 3, 2, 1]
let take A[1] information,
we have 2 subarrays for which A[1] is the smallest in the left