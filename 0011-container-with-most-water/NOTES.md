# Optimal Approach
Always move the shorter pointer ahead :
Initially we consider the area constituting the exterior most lines. Now, to maximize the area, we need to consider the area between the lines of larger lengths. If we try to move the pointer at the longer line inwards, we won't gain any increase in area, since it is limited by the shorter line. But moving the shorter line's pointer could turn out to be beneficial, as per the same argument, despite the reduction in the width. This is done since a relatively longer line obtained by moving the shorter line's pointer might overcome the reduction in area caused by the width reduction.
​
​
```
class Solution {
public int maxArea(int[] h) {
int water = 0;
int l = 0, r = h.length-1;
while(l<=r) {
water = Math.max(water, (r-l) * Math.min(h[l], h[r]));
if(h[l] < h[r]) l++;
else r--;
}
return water;
}
}
```