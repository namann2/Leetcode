This problem is asked in google with an extension to solve it in-place ( which is super cool )

## Approach 1 : 
If we are bound with a constraint on the nums[i] then, we can use the below approach : 

Aim : Organise the numbers (of required sequence) such a way that we can segregate them later and put them to their correct index.
```
class Solution {
    public int[] shuffle(int[] nums, int n) {
        // taking 10's because the uniqueness of the number won't be lost. Additionaly, taking a power more (10^4 and not 10^3) since nums[i] can be 10^3
        // since in this way, the number is still retained.
        int CONSTANT = 10000; 
        for(int i = 0; i < n; i++) {
            nums[i] += (nums[i + n] * CONSTANT);
        }
        
        for(int i = n-1; i >= 0; i--) {
            nums[2 * i + 1] = nums[i] / CONSTANT;
            nums[2 * i] = nums[i] % CONSTANT;
        }
        return nums;
    }
}
```

