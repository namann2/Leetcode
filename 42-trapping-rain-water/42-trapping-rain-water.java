class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0], rightMax = height[n-1];
        int maxWater = 0;
        
        int left = 0, right = n-1;
        while(left < right) {
            if(leftMax <= rightMax) {
                maxWater += (leftMax - height[left]);
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                maxWater += (rightMax - height[right]);
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return maxWater;
    }
}