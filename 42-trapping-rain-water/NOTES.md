Approach 2 : 
```
class Solution {
    public int trap(int[] height) {
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
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return water;
    }
}
```

****

Approach. 1 : 
TC  = SC = O(n)
```
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = height[0]; // on the left of 0th buildng their is no building
        for(int i=1;i<n;i++) {
            left[i] = Math.max(height[i], left[i-1]);
        }
        
        right[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--) {
            right[i] = Math.max(height[i], right[i+1]);
        }
        
        int maxWater = 0;
        for(int i=0;i<n;i++) {
            maxWater += Math.min(left[i], right[i]) - height[i];
        }
        return maxWater;
    }
}

```


