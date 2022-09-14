left = pointer that points to the location that needs to be updated with a 0 value
right = pointer that points to the location that needs to be updated with 2 value
mid = iterator that iterates through the array
​
```
class Solution {
public void sortColors(int[] nums) {
if(nums==null || nums.length == 0) return;
int n = nums.length;
int left = 0;
int right = n-1;
int mid = 0;
while(mid <= right) {
if(nums[mid]==0) {
swap(nums, left, mid);
left++;
mid++;
}
else if(nums[mid]==1) {
mid++;
}