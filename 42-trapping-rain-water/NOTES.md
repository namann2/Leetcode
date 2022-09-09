Approach 2 :
```
class Solution {
public int trap(int[] height) {
/*
Notes:
jonsa bhi max chota hoga ,
i can with sureity say ki us side ka
container kitna water store karega
*/
if(height.length == 1) return 0;
int leftMax = height[0];
int rightMax = height[height.length-1];
int water = 0;
int left = 0, right = height.length-1;
while(left < right) {
if(leftMax < rightMax) {
// I can surely fill the left index
water += leftMax - height[left];
left++;
leftMax = Math.max(height[left], leftMax);
} else {
// I can surely say the amount of water that can be filled on right idx
water += rightMax - height[right];