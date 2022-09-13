class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[]Ls = findSmallerContributionLeft(nums);
        int[]Rs = findSmallerContributionRight(nums);
        
        int[]Lg = findBiggerContributionLeft(nums);
        int[]Rg = findBiggerContributionRight(nums);
        
        long result = 0;
        
        for(int i=0;i<n;i++) {
            long l = Ls[i] * Rs[i];
            long r = Lg[i] * Rg[i];
            result += nums[i] * (r-l);
        }
        
        return result;
    }
    
    private int[] findSmallerContributionLeft(int[] A) {
        int n = A.length;
        int[]res = new int[n];
        Stack<Integer> stack = new Stack<>();
        // contribution of A[i] as smallest element on left
        // i.e. find index of first smallest element on left
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]) stack.pop();
            res[i] = stack.isEmpty() ? i+1 : i - stack.peek();
            stack.push(i);
        }
        return res;
    }
    
    private int[] findSmallerContributionRight(int[] A) {
        int n = A.length;
        int[]res = new int[n];
        Stack<Integer> stack = new Stack<>();
        // contribution of A[i] as smallest element on right
        // i.e. find index of first smallest element on right
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) stack.pop();
            res[i] = stack.isEmpty() ? n-i : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
    
    private int[] findBiggerContributionLeft(int[] A) {
        int n = A.length;
        int[]res = new int[n];
        Stack<Integer> stack = new Stack<>();
        // contribution of A[i] as largest element on left
        // i.e find index of first largest element on left
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]) stack.pop();
            res[i] = stack.isEmpty() ? i+1 : i - stack.peek();
            stack.push(i);
        }
        return res;
    }
    
    private int[] findBiggerContributionRight(int[] A) {
        int n = A.length;
        int[]res = new int[n];
        Stack<Integer> stack = new Stack<>();
        // contribution of A[i] as the largest element on right
        // i.e. find index of largest element on the right
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) stack.pop();
            res[i] = stack.isEmpty() ? n-i : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}