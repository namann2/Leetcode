class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] minL = new int[n], maxR = new int[n];
        minL[0] = nums[0];
        for(int i=1; i < n; i++) {
            minL[i] = Math.min(minL[i-1], nums[i]);
        }
        maxR[n-1] = nums[n-1];
        for(int i=n-2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i+1], nums[i]);
        }
        
        int maxW = 0, i = 0, j = 0;
        while(i < n && j < n) {
            if(minL[i] <= maxR[j]) {
                maxW = Math.max(maxW, j - i);
                j++;
            } else i++;
        }
        return maxW;
    }
}

// [6,0,8,2,1,5]
// [6,0,0,0,0,0]
//    i
// [8,8,8,5,5,5]
//.           j
