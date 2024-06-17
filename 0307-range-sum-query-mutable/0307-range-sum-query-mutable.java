class NumArray {
    int n;
    int []nums, bit;
    public NumArray(int[] nums) {
        n = nums.length;
        this.nums = nums;
        this.bit = new int[n+1];
        buildTree();
    }
    
    private void buildTree() {
        for(int i = 0; i < n; i++)
            add(i, nums[i]);
    }
    
    private void add(int index, int val) {
        index++;
        while(index <= n) {
            bit[index] += val;
            index += (index & -index);
        }
    }
    
    private int getSum(int index) {
        int sum = 0;
        index++;
        while(index > 0) {
            sum += bit[index];
            index -= (index & -index);
        }
        return sum;
    }
    
    public void update(int index, int val) {
        int diff = -nums[index] + val;
        nums[index] = val;
        add(index, diff);
    }
    
    public int sumRange(int left, int right) {
        return getSum(right) - getSum(left-1);
    }
}