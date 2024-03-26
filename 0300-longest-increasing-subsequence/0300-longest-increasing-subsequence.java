class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < n; i++) {
            if(nums[i] > list.get(list.size()-1))
                list.add(nums[i]);
            else {
                int index = binarySearch(nums[i], list);
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }
    private int binarySearch(int val, List<Integer> list) {
        int start = 0, end = list.size()-1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(list.get(mid) >= val) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return start;
    }
}