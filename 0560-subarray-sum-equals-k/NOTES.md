similar problem : https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
# if we are talking about only positive numbers :
​
```
class Solution {
public int subarraySum(int[] nums, int k) {
int begin = 0;
int end = 0;
int count = 0;
int sum = 0;
while(end < nums.length) {
sum+=nums[end];
if(sum < k) end++;
else if(sum == k) {
count++;
end++;
} else if(sum > k) {
while(sum > k) {
sum-=nums[begin++];
}
if(sum == k) count++;
end++;
}