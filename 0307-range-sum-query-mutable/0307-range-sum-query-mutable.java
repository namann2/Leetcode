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