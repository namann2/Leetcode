Helpful : [ for optimal -> binary search approach ]
https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326308/C%2B%2BPython-DP-Binary-Search-BIT-Solutions-Picture-explain-O(NlogN)

# Naive : 
TC : `O(n^2)`
SC : `O(n)`

---------------------------------------------
# Optimal : 

Let's construct the idea from following example.

Consider the example nums = [2, 6, 8, 3, 4, 5, 1], let's try to build the increasing subsequences starting with an empty one: sub1 = [].
- Let pick the first element, sub1 = [2].
- 6 is greater than previous number, sub1 = [2, 6]
- 8 is greater than previous number, sub1 = [2, 6, 8]
- 3 is less than previous number, we can't extend the subsequence sub1, but we must keep 3 because in the future there may have the longest subsequence start with [2, 3], sub1 = [2, 6, 8], sub2 = [2, 3].
- With 4, we can't extend sub1, but we can extend sub2, so sub1 = [2, 6, 8], sub2 = [2, 3, 4].
- With 5, we can't extend sub1, but we can extend sub2, so sub1 = [2, 6, 8], sub2 = [2, 3, 4, 5].
- With 1, we can't extend neighter sub1 nor sub2, but we need to keep 1, so sub1 = [2, 6, 8], sub2 = [2, 3, 4, 5], sub3 = [1].
- Finally, length of longest increase subsequence = len(sub2) = 4.

In the above steps, we need to keep different sub arrays (sub1, sub2..., subk) which causes poor performance. But we notice that we can just keep one sub array, when new number x is not greater than the last element of the subsequence sub, we do binary search to find the smallest element >= x in sub, and replace with number x.

⭐️ Note : This gives us the length of longest increasing subsequence and not the actual LIS.

```
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
```
