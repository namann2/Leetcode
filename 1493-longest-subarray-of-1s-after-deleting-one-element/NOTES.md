

​### Approach 1 : Naive Approach
This is the basic intuition that I got while reading the question, so I coded it this way.

Note : This is a general type of problem where we are given a string and we have the option to delete k characters from it and have to return max length of consecutive elements. This is done using `sliding window.`

The below code worked for k=1, but for more generalised solution, we must follow sliding window

```
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] onesOnLeft = new int[n];
        int[] onesOnRight = new int[n];
        
        int ones = nums[0] == 1 ? 1 : 0;
        for(int i = 1; i < n; i++) {
            onesOnLeft[i] = ones;
            if(nums[i] == 0) ones = 0;
            else ones += 1;
        }
        
        ones = nums[n-1] == 1 ? 1 : 0;
        for(int i = n-2 ; i >= 0; i--) {
            onesOnRight[i] = ones;
            if(nums[i] == 0) ones = 0;
            else ones += 1;
        }
        
        int maxLength = 0;
        for(int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, onesOnLeft[i] + onesOnRight[i]);
        }
        
        return maxLength;
    }
}
```


### Sliding Window Approach 
```
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int begin = 0, end = 0, maxLength = 0, zeros = 0, k = 1;
        while(end < n) {
            if(nums[end] == 1) {
                // we need to delete one char
                maxLength = Math.max(maxLength, end - begin);
                end++;
            } else {
                zeros++;
                while(zeros > k) {
                    if(nums[begin] == 0) zeros--;
                    begin++;
                }
                maxLength = Math.max(maxLength, end - begin);
                end++;
            }
        }
        return maxLength;
    }
}
```
