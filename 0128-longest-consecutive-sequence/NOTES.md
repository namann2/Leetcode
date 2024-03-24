# Sorting :
## TC : O(n log n) , SC : O(n)
​
```
​
class Solution {
public int longestConsecutive(int[] nums) {
int n = nums.length;
if(n == 0 || n == 1) return n;
Arrays.sort(nums);
int[] lcs = new int[n];
Arrays.fill(lcs, 1);
// lcs[i] = longest consecutive sequence ending at i
int answer = 1;
for(int i=1;i<n;i++) {
// only two cases, since the array is sorted
if(nums[i] == nums[i-1] + 1)
lcs[i] = lcs[i-1] + 1;
else if(nums[i] == nums[i-1])
lcs[i] = lcs[i-1];
answer = Math.max(answer, lcs[i]);
}
​