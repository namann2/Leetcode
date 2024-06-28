https://leetcode.com/articles/a-recursive-approach-to-segment-trees-range-sum-queries-lazy-propagation/

- Segment tree is a full binary tree which has n leaves and A[i] are represented as leaves in the tree structure and is the reason that Segment tree is built up in bottom up fashion.

- For i, two child nodes will lie at index 2i + 1 and 2i + 2. Moreover, For a node at index i, the parent will be floor( i - 1 / 2 )th index.

Let's take a look at the build process. We visit each leaf of the segment tree (corresponding to each element in our array arr[]). That makes nn leaves. Also there will be n-1 internal nodes. So we process about 2*n nodes. This makes the build process run in O(n)Olinear complexity.

Both the read and update queries now take logarithmic O(log_2(n)) which was required.


The update process discards half of the range for every level of recursion to reach the appropriate leaf in the tree. This is similar to binary search and takes logarithmic time. After the leaf is updated, its direct ancestors at each level of the tree are updated. This takes time linear to height of the tree. ( O(logn base 2))

The read/query process traverses depth-first through the tree looking for node(s) that match exactly with the queried range. At best, we query for the entire range and get our result from the root of the segment tree itself. At worst, we query for a interval/range of size 11 (which corresponds to a single element), and we end up traversing through the height of the tree. This takes time linear to height of the tree.

### Why 4n size is required ?
The height of the segment tree is O(log n) because while moving from the root to the leaves at every level, the length of the segments is reduced by half.
 
The total number of nodes involved in the segment tree is 4*n.
The total number of levels is log n and starting from one node at the first level, the number of nodes gets doubled at every level. 
So, total number of nodes = 1+2+4+8+....+2^(log n) = 2^(logn + 1) -1 < 4n.

When n is not a power of 2, the tree becomes a complete binary tree rather than a perfect binary tree.
This means additional nodes are needed to accommodate the extra levels, ensuring the tree structure remains balanced.

# Segment Tree : 

```
class NumArray {
    
    int n;
    int[] nums;
    SegmentTree obj;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        obj = new SegmentTree(n);
        obj.buildTree(nums, 0, n-1, 0); // nums, left, right, tree_index
    }
    
    public void update(int index, int val) {
        nums[index] = val;
        obj.update(0, n-1, index, val, 0); // left, right, to_update_index, with_val, tree_index
    }
    
    public int sumRange(int left, int right) {
        return obj.getSum(0, n-1, left, right, 0); // complete_range[0, n-1], required_range[left, right]
    }
}

class SegmentTree {
    int n;
    int[] tree;
    
    public SegmentTree(int n) {
        this.n = 4 * n;
        tree = new int[this.n];
    }
    
    public void buildTree(int[] nums, int left, int right, int tree_index) {
        if(left == right) {
            tree[tree_index] = nums[left];
            return;
        }
        
        int mid = left + (right - left) / 2;
        
        buildTree(nums, left, mid, 2 * tree_index + 1);
        buildTree(nums, mid + 1, right, 2 * tree_index + 2);
        
        tree[tree_index] = tree[2 * tree_index + 1] + tree[2 * tree_index + 2];
    }
    
    public void update(int left, int right, int index, int val, int tree_index) {
        if(left == right) {
            tree[tree_index] = val;
            return;
        }
        
        int mid = left + (right - left) / 2;
        if(index <= mid)
            update(left, mid, index, val, 2 * tree_index + 1);
        else update(mid + 1, right, index, val, 2 * tree_index + 2);
        
        tree[tree_index] = tree[2 * tree_index + 1] + tree[2 * tree_index + 2];
    }
    
    public int getSum(int L, int R, int left, int right, int tree_index) {
        // three conditions
        // complete overlap..L...left...right..R
        if(L >= left && R <= right)
            return tree[tree_index];
        // no overlap
        if(left > R || right < L)
            return 0;
        // complete overlap
        if(L >= left && R <= right)
            return tree[tree_index];
        // partial overlap
        int mid = L + (R - L) / 2;
        
        int l = getSum(L, mid, left, right, 2 * tree_index + 1);
        int r = getSum(mid + 1, R, left, right, 2 * tree_index + 2);
        
        return l + r;
    }
}

 ```
 
 
 # BIT / Fenwick Tree 
 
 ```
 class NumArray {
    int[] nums;
    int n;
    private FenwickTree fenwick;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        fenwick = new FenwickTree(n);
        
        for(int i = 0; i < n; i++)
            fenwick.update(i, nums[i]);
    }
    
    public void update(int index, int val) {
        int diff = -nums[index] + val;
        nums[index] = val;
        fenwick.update(index, diff);
    }
    
    public int sumRange(int left, int right) {
        return fenwick.sumRange(right) - fenwick.sumRange(left - 1);
    }
}

class FenwickTree {
    int n;
    int[] bit;
    
    public FenwickTree(int n) {
        this.n = n + 1;
        this.bit = new int[this.n];
    }
    
    public void update(int index, int val) {
        index++;
        while(index < n) {
            bit[index] += val;
            index += (index & -index);
        }
    }
    
    public int sumRange(int index) {
        index++;
        int sum = 0;
        while(index > 0) {
            sum += bit[index];
            index -= (index & -index);
        }
        return sum;
    }
}
```
