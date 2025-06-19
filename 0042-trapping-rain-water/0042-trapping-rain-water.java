class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0], rightMax = height[n-1];
        int left = 0, right = n-1;
        int water = 0;
        while(left < right) {
            if(leftMax <= rightMax) {
                water += leftMax - height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                water += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return water;
    }
}