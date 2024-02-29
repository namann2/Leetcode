class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int count = 0, n = nums.size();
        for(int i=0;i<n;i++) {
            int num = nums.get(i);
            int bitCount = Integer.bitCount(i);
            if(bitCount == k) count += num;
        }
        return count;
    }
}