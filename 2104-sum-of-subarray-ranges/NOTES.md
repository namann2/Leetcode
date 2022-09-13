# Similar Problems : 
1. Sum of Subarray Minimums
2. Sum of Total Strength of Wizards
3. Number of Visible People in a Queue

# Solution : 

```
class Solution {
    public long subArrayRanges(int[] A) {
        int n = A.length;
        
        Deque<Integer> stack = new ArrayDeque<>();
        // subarrays in which A[i] is min on left and right
        long[] left = new long[n];
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]) stack.pop();
            left[i] = stack.size() == 0 ? i+1 : i-stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        long[] right = new long[n];
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) stack.pop();
            right[i] = stack.size() == 0 ? n-i : stack.peek()-i;
            stack.push(i);
        }
        
        stack.clear();
        // subarrays in which A[i] is largest on left and right
        long[]L = new long[n];
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]) stack.pop();
            L[i] = stack.size() == 0 ? i+1 : i-stack.peek();
            stack.push(i);
        }
        
        stack.clear();

        long[] R = new long[n];
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) stack.pop();
            R[i] = stack.size() == 0 ? n-i : stack.peek()-i;
            stack.push(i);
        }
        
        long result = 0;
        for(int i=0;i<n;i++) {
            long l = left[i] * right[i]; // contribution in minimums
            long r = L[i] * R[i]; // contribution in maximums
            result += (A[i] * (r-l));
        }

        return result;
    }
}
```
