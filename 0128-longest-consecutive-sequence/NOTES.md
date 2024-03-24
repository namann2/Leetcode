# Sorting :

## TC : O(n log n) , SC : O(n)
​
1. Sort the array
2. Remove the duplicates ( here , I have adjusted the code to handle the duplicates and not removed them )
3. Check the length of consecutive elements

but we require, an algorithm that runs in `O(n)`...

```
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;
        
        Arrays.sort(nums);
        int[] lcs = new int[n];
        int answer = 1;
        lcs[n-1] = 1;
        for(int i=n-2;i>=0;i--) {
            if(nums[i] + 1 == nums[i+1]) lcs[i] = lcs[i+1] + 1;
            else if(nums[i] == nums[i+1]) lcs[i] = lcs[i+1];
            else lcs[i] = 1;
            answer = Math.max(answer, lcs[i]);
        }
        return answer;
    }
}
```
​
