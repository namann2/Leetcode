### Video Link : 
https://www.youtube.com/watch?v=rszwy53vaP0



## Solution Description : 

# Approach 1: Naive Backtracking
Intuition

Our goal is to break the given array into k subsets of equal sums.
Firstly, we will check if the array sum can be evenly divided into k parts by ensuring that totalArraySum % k is equal to 0.

Now, if the array sum can be evenly divided into k parts, as previously mentioned, we will try to build those k subsets using backtracking.

We will keep a currentSum variable denoting the sum of the current subset. One by one, try to include each element from the array that has not already been picked and then make a recursive call to pick the next element.
To keep track of already picked elements we will use a vector (taken) to denote if the element at the ith index has already been picked or not.
When we pick the ith element, we will set taken[i] equal to true. Then after we try all combinations, we will backtrack and discard the picked element by setting taken[i] equal to false so that it can be picked in a future recursive call.

If we reach the condition currentSum is greater than targetSum, then we cannot reach the target by adding more elements to the subset, so there is no need to proceed further; we can just backtrack from here.
If we reach the condition, currentSum equals targetSum, that means we made one subset with the target sum. So now we can increment a count variable that counts how many subsets with a sum equal to the target we have made from our array.
When count becomes k, that means we have made k equal sum subsets of our array; hence we can return true.
Finally, when count becomes k - 1, that means we have k equal sum subsets in our array because the totalArraySum is divisible by k and the sum of k - 1 subsets will be (k - 1) * targetSum, hence the last subset-sum must also equal targetSum. So we can stop at condition count == k - 1 to save some time by skipping a few redundant recursive calls.

```
class Solution {
    private boolean backtrack(int[] arr, int count, int currSum, int k, int targetSum, boolean[] taken) {
        int n = arr.length;
      
        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) { 
            return true;
        }
        
        // Current subset sum exceeds target sum, no need to proceed further.
        if (currSum > targetSum) { 
            return false;
        }
      
        // When current subset sum reaches target sum then one subset is made.
        // Increment count and reset current subset sum to 0.
        if (currSum == targetSum) {
            return backtrack(arr, count + 1, 0, k, targetSum, taken);
        }
        
        // Try not picked elements to make some combinations.
        for (int j = 0; j < n; ++j) {
            if (!taken[j]) {
                // Include this element in current subset.
                taken[j] = true;
                
                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, count, currSum + arr[j], k, targetSum, taken)) {
                    return true;
                }
                
                // Backtrack step.
                taken[j] = false;
            }
        } 
      
        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        return false;
    }
  
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;
        
        for (int i = 0; i < n; ++i) {
             totalArraySum += arr[i];
        }
      
        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) { 
            return false;
        }
      
        int targetSum = totalArraySum / k;
        boolean[] taken = new boolean[n];
      
        return backtrack(arr, 0, 0, k, targetSum, taken);
    }
}
```

# Complexity Analysis

Let N denote the number of elements in the array.

Time complexity: O(N⋅N!).

The idea is that for each recursive call, we will iterate over N elements and make another recursive call. Assume we picked one element, then we iterate over the array and make recursive calls for the next N-1 elements and so on.
Therefore, in the worst-case scenario, the total number of recursive calls will be N⋅(N−1)⋅(N−2)⋅...⋅2⋅1=N!  and in each recursive call we perform an O(N) time operation ( by iterating over the array from 0th index )

We have used an extra array of size NN to mark the picked elements.
And the maximum depth of the recursive tree is at most NN, so the recursive stack also takes O(N) space.

## Solution 2 : Optimized Backtracking

1. Used a variable (index) to start the finding of a value rather than searching complete array
[
We are doing this because it allows us to skip checking the elements that are already picked. Also, if there is an element that was skipped earlier, then that element will be skipped again because now the subset-sum has increased; if it did not fit in the subset earlier, it would not fit now.
]
2. Sort the array 
[
If we had sorted the array in ascending order (smaller values on the left side), then there would be more recursion branches (recursive calls). This is because when the change in subset-sum is small, more branches will be repeatedly created during the backtracking process.
]
/

# POINT !!
CHECK BACK to BACK SWE video. He mentioned that we can simulate the process, but we can actually code it in a simple way
# The point here ?
The point here is that we are not actually filling the k buckets. We can do that, it is one of the approaches.
But we will simulate the process.
Pick an element, and find the other elements that we can use to form one subset. ( Mark them visited so that we do not re-use them again).
Same process goes until we reach our result.

```
class Solution {
    public boolean canPartitionKSubsets(int[] A, int k) {
        int n = A.length;
        int sum = Arrays.stream(A).sum();
        if(sum % k != 0) return false;
        
        int target = sum / k;
        for(int num : A)
            if(num > target) return false;
        
        Arrays.sort(A);

        return canPartition(A, n-1, k, new boolean[n], 0, target, n);
    }
    private boolean canPartition(int[]A, int index, int k, boolean[] used, int currsum, int target, int n) {
        // base case
        // if(k==0) 
        //     return true;
        if(k==1)  // we could do this, we know that we can parition the array into k parts,
            // if k==1, means we would be skipping a few elements that would still end-up in the same bucket, so we are saving computations 
            return true;
        if(currsum == target)
            return canPartition(A, n-1, k-1, used, 0, target, n);

        for(int i=index;i>=0;i--) {
            if(used[i] || currsum + A[i] > target) continue;
            used[i] = true;
            if(canPartition(A, i-1, k, used, currsum + A[i], target, n)) return true;
            used[i] = false;
        }
        return false;
    }
}
```

Time complexity:O(k⋅ 2 ^ N).
We are traversing the entire array for each subset (once we are done with one subset, for the next subset we are starting again with index nums.length-1). So for each subset, we are choosing the suitable elements from the array (basically iterate over nums and for each element either use it or skip it, which is O(2^N) operation).

`Why do the recursive calls for including and not including elements have O(2^N) ?`
The idea is that we have two choices for each element: include it in the subset OR not include it in the subset. We have N such elements. Therefore, the number of cases for events of including/excluding all numbers is: 2⋅2⋅2⋅...(Ntimes)..⋅2=2^N

Space Complexity : 

We have used an extra array of size N to mark the already used elements.
And the recursive tree makes at most N calls at one time, so the recursive stack also takes O(N) space.


## Solution 3 : Dynamic Programming
```
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0)  // it is not possible to divide the entire array in k subportions
            return false;
        // ques : do we need exactly k subsets -> yes
        int required = sum / k;
        for(int num : nums) 
            if(num > required) return false;

        // doesn't determining above conditions allows us to conclude paritioning ?
        // No, above conditions concluded that it is possible to break given input into k subportions
        // but, whether the sum of all those paritions are equal or not isn't sure.
        // eg : [2,2,2,2,5,5,2], k = 4
        int n = nums.length;
        Arrays.sort(nums);
        return canPartition(nums, 0, n, required, required, k, new boolean[n]);
    }

    private boolean canPartition(int[] nums, int index, int n, int orgTarget, int target, int count, boolean[] used) {
        // base case
        if(count == 0) return true;
        if(target == 0) return canPartition(nums, 0, n, orgTarget, orgTarget, count - 1, used);
        if(target < 0) return false;
        // main logic
        for(int i = index; i < n; i++) {
            if(used[i] || target - nums[i] < 0) continue;
            used[i] = true;
            if(canPartition(nums, i + 1, n, orgTarget, target - nums[i], count, used))
                return true;
            used[i] = false;
        }
        return false;
    }
}
```
