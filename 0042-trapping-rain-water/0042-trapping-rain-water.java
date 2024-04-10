class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int L = height[0], R = height[n-1];
        int l = 0, r = n-1, water = 0;
        while(l < r) {
            if(L <= R) {
                water += L - height[l];
                l++;
                L = Math.max(L, height[l]);
            } else {
                water += R - height[r];
                r--;
                R = Math.max(R, height[r]);
            }
        }
        return water;
    }
}
