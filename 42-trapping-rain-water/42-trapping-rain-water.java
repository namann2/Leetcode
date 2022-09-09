class Solution {
    public int trap(int[] height) {
        /*
            Topic Segregation :
            We need to find the max water that can be stored. Hence,
            possible solutions : 
            Brute Force
            Greedy
            DP
            Binary Search
            
            Brute Force would be O(n^2) ~ 10^8 so, it won't work
            Binary Search/DP is ruled out 
            Greedy should work !
            
            Generally, greedy problems implements sorting or use of heaps or a tricky mind-boggling solution
        */
        int n = height.length;
        int[]L = new int[n];
        int[]R = new int[n];
        
        /* Find max building on the left and on the right for a particular building 
            as that much water could be stored on the current building
        */
        
        L[0] = height[0];
        for(int i=1;i<n;i++) {
            L[i] = Math.max(height[i], L[i-1]);
        }
        
        R[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--) {
            R[i] = Math.max(height[i], R[i+1]);
        }
        
        int maxWater = 0;
        for(int i=0;i<n;i++) 
            maxWater += (Math.min(L[i], R[i]) - height[i]);
        
        return maxWater;
    }
}