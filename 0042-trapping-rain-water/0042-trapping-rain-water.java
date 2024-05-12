class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[]L = new int[n];
        int[]R = new int[n];
        
        L[0] = height[0];
        for(int i=1;i<n;i++)
            L[i] = Math.max(L[i-1], height[i]);
        
        R[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--)
            R[i] = Math.max(R[i+1], height[i]);
        
        int maxWater = 0;
        for(int i = 0; i < n; i++)
            maxWater += Math.min(L[i], R[i]) - height[i];
        
        return maxWater;
    }
}