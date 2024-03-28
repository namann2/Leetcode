## Naive Approach : Classic LIS [ TLE ]

```
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        int n = nums.length;
        int[]dp = new int[n];
        dp[0] = nums[0];
        int maxsum = dp[0];
        for(int i = 1; i < n; i++) {
            int currsum = nums[i];
            for(int j = Math.max(0, i-k); j < i; j++) {
                currsum = Math.max(currsum, dp[j] + nums[i]);
            }
            dp[i] = currsum;
            maxsum = Math.max(maxsum, dp[i]);
        }
        return maxsum;
    }
}
```

# Optimal Approach : Heaps

Started off with a normal LIS solution, double loop but the issue with that is,
it is n^2 and the constraints won't allow this solution. Hence, this is hard.
            
Intuition for optimal : 

For a particular number, we only care about the k max sum. 
If we can get a max sum out of those k values for an index i, 
we can do the solution in less time complexity. How can we do it ?
            
Using heaps.

            
```
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        }); // [index, nums[index]]

        int n = nums.length, maxsum = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            while(!maxHeap.isEmpty() && i - maxHeap.peek()[0] > k) {
                maxHeap.remove();
            }
            int currsum = nums[i] + (maxHeap.isEmpty() ? 0 : maxHeap.peek()[1]);
            currsum = Math.max(currsum, nums[i]);
            maxHeap.offer(new int[]{i, currsum});
            maxsum = Math.max(maxsum, currsum);
        }
        return maxsum;
    }
}
```
