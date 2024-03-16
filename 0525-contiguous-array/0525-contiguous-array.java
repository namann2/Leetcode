class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0, n = nums.length, currsum = 0;
        for(int i = 0 ; i < n; i++) {
            currsum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(currsum))
                maxLength = Math.max(maxLength, i - map.get(currsum));
            else map.put(currsum, i);
        }
        return maxLength;
    }
}
// _  0  0  1  1 0 0 1 1 0
// -1 -1 -2 -1