class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            if(list.size() == 0 || num > list.get(list.size()-1)) list.add(num);
            else {
                int index = binarySearch(list, num);
                if(index < list.size()) list.set(index, num);
            }
        }
        return list.size();
    }
    
    private int binarySearch(List<Integer> list, int num) {
        int n = list.size();
        int start = 0, end = n-1;
        // 1 3 5 6, 5
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(num > list.get(mid)) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return start;
    }
} 