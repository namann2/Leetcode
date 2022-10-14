class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        
        int maxLength = 0;
        int begin = 0, end = 0, n = nums.length;
        while(end < n ) {
            while(!min.isEmpty() && nums[min.peekLast()] > nums[end]) min.removeLast();
            while(!max.isEmpty() && nums[max.peekLast()] < nums[end]) max.removeLast();
            min.addLast(end);
            max.addLast(end);
            while(nums[max.peekFirst()] - nums[min.peekFirst()] > limit && begin < end) {
                if(nums[min.peekFirst()] == nums[begin]) min.removeFirst();
                if(nums[max.peekFirst()] == nums[begin]) max.removeFirst();
                begin++;
            }
            if(nums[max.peekFirst()] - nums[min.peekFirst()] <= limit) 
                maxLength = Math.max(maxLength, end - begin + 1);
            end ++;
        }
        return maxLength;
    }
}