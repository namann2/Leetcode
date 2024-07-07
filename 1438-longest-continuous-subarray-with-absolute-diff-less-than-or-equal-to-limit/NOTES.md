​## Approch 1 : TreeMap

[ THIS SHOULD BE INTUITIVE ]

This is a classic sliding window problem with a constraint.

TC : O(n . logn)
SC : O(n)
```
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> numFreq = new TreeMap<>();
        int end = 0, begin = 0, maxLength = 0, n = nums.length;
        while(end < n) {
            numFreq.put(nums[end], numFreq.getOrDefault(nums[end], 0) + 1);
            while(numFreq.lastKey() - numFreq.firstKey() > limit) {
                int min = nums[begin];
                numFreq.put(min, numFreq.get(min) - 1);
                if(numFreq.get(min) <= 0) {
                    numFreq.remove(min);
                }
                begin++;
            }
            if(numFreq.lastKey() - numFreq.firstKey() <= limit) {
                maxLength = Math.max(maxLength, end - begin + 1);
            }
            end++;
        }
        return maxLength;
    }
}
```

## Approch 2 : Using Two Deque

TC : O(n)
SC : (n)

```
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        
        int end = 0, begin = 0, maxLength = 0, n = nums.length;
        
        while(end < n) {
            while(!min.isEmpty() && nums[min.peekLast()] > nums[end]) min.removeLast();
            while(!max.isEmpty() && nums[max.peekLast()] < nums[end]) max.removeLast();
            min.addLast(end);
            max.addLast(end);
            while(!max.isEmpty() && !min.isEmpty() && nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                if(nums[min.peekFirst()] == nums[begin]) min.removeFirst();
                if(nums[max.peekFirst()] == nums[begin]) max.removeFirst();
                begin++;
            }
            if(nums[max.peekFirst()] - nums[min.peekFirst()] <= limit) {
               maxLength = Math.max(maxLength, end - begin + 1); 
            }
            end++;
        }
        return maxLength;
    }
}
```
