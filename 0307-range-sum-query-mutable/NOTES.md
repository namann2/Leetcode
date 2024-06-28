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
### Why 4n size is required ?
The height of the segment tree is O(log n) because while moving from the root to the leaves at every level, the length of the segments is reduced by half.
The total number of nodes involved in the segment tree is 4*n.
The total number of levels is log n and starting from one node at the first level, the number of nodes gets doubled at every level.
So, total number of nodes = 1+2+4+8+....+2^(log n) = 2^(logn + 1) -1 < 4n.
# Segment Tree :
```
class NumArray {
private int[] A, tree;
private int n;
public NumArray(int[] nums) {
n = nums.length;
A = nums;
tree = new int[4*n];
buildTree(0, n-1, 0);
}
public void update(int index, int val) {
int updateWithDiff = val - A[index];
A[index] = val;
updateUtil(0, n-1, index, updateWithDiff, 0);
}
public int sumRange(int left, int right) {
return sumRangeUtil(left, right, 0, n-1, 0);
}
private int sumRangeUtil(int left, int right, int L, int R, int st) {
// three conditions
// complete overlap left. ...L.....R. . . . right
if(L >= left && R <= right) return tree[st];