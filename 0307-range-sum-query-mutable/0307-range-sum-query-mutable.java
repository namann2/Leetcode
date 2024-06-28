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