https://leetcode.com/articles/a-recursive-approach-to-segment-trees-range-sum-queries-lazy-propagation/
​
Let's take a look at the build process. We visit each leaf of the segment tree (corresponding to each element in our array arr[]). That makes nn leaves. Also there will be n-1 internal nodes. So we process about 2*n nodes. This makes the build process run in O(n)Olinear complexity.
​
Both the read and update queries now take logarithmic O(log_2(n)) which was required.
​
​
The update process discards half of the range for every level of recursion to reach the appropriate leaf in the tree. This is similar to binary search and takes logarithmic time. After the leaf is updated, its direct ancestors at each level of the tree are updated. This takes time linear to height of the tree. ( O(logn base 2))
​
The read/query process traverses depth-first through the tree looking for node(s) that match exactly with the queried range. At best, we query for the entire range and get our result from the root of the segment tree itself. At worst, we query for a interval/range of size 11 (which corresponds to a single element), and we end up traversing through the height of the tree. This takes time linear to height of the tree.
​
​
# Code :
```
class NumArray {
private int[] A, tree;