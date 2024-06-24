class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxWater = 0, left = 0, right = n-1;
        while(left < right) {
            maxWater = Math.max(maxWater, Math.min(height[right], height[left]) * (right - left));
            if(height[left] <= height[right]) left++;
            else right--;
        }
        return maxWater;
    }
}