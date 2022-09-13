class Solution {
    public int sumSubarrayMins(int[] A) {
        int n = A.length;
        int[] Ls = findSmallerContributionLeft(A);
        int[] Rs = findSmallerContributionRight(A);
        
        long result = 0;
        int mod = (int)1e9+7;
        
        for(int i=0;i<n;i++) {
            long contri = (Ls[i] % mod * Rs[i] % mod) % mod;
            result = result % mod + (A[i] % mod * contri % mod) % mod;
        }
        
        return (int)result;
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
}