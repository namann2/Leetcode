When we talk about Longest Common Substring :
We have two options :
* Sliding Window : **[ Can be used when only len is asked ]**
* TC : `O(nm) * O(min(n,m))`, SC : `O(1)`
* DP : **[ Can be used when either len or actual longest sunbstring is asked ]**
* TC : `O(nm)`, SC : `O(nm)`
​
# Sliding Window Approach :
https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/109059/O(mn)-time-O(1)-space-solution
​
// The initial position and the directions in which we slide. One step means shifting the  // top array by one position (index) to the right, or the the bottom array by one position  // (index) to the left:
//          [1,2,3,2,1]   -->
//           <--    [3,2,1,4,7]
//          [1,2,3,2,1]
//                [3,2,1,4,7]
//          [1,2,3,2,1]      -->
//     <--      [3,2,1,4,7]
​
and so on
```