class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, maxProduct = Integer.MIN_VALUE;
        int product = 1;
        for(int i = 0; i < n; i++) {
            product *= nums[i]; // ending at nums[i]
            // if(nums[i] > product) product = nums[i]; // starting from nums[i] indicating start of new subarray
            maxProduct = Math.max(maxProduct, product);
            if(product == 0) product = 1; // making sure we can mark start of a new subarray starting from i
        }
        
        product = 1;
        for(int i = n-1; i >= 0; i--) {
            product *= nums[i];
            // if(nums[i] > product) product = nums[i];
            maxProduct = Math.max(maxProduct, product);
            if(product == 0) product = 1;
        }
        return maxProduct;
    }
}