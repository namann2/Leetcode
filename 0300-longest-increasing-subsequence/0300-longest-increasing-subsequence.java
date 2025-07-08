class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(list.size() == 0 || nums[i] > list.get(list.size()-1)) list.add(nums[i]);
            else {
                int index = findInsertionIndex(list, list.size(), nums[i]);
                // TODO : update the logic based on value of index
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }

    // helper function
    private int findInsertionIndex(List<Integer> list, int n, int ele) {
        int start = 0, end = n-1, ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(list.get(mid) >= ele) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
}