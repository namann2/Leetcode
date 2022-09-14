# Logic : 

In-place algorithm means to use : 
1. replacements
2. swappings
3. variables

We can use above algorithms to work on an in-place algorithm

- left = pointer that points to the location that needs to be updated with a 0 value
- right = pointer that points to the location that needs to be updated with 2 value
- mid = iterator that iterates through the array

```
class Solution {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length == 0) return;
        
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int mid = 0;
        
        while(mid <= right) {
            
            if(nums[mid]==0) {
                swap(nums, left, mid);
                left++;
                mid++;
            } 
            else if(nums[mid]==1) {
                mid++;
            } 
            else if(nums[mid]==2) {
                swap(nums, mid, right);
                right--;
            }
        }
        
    }
    private void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
```
