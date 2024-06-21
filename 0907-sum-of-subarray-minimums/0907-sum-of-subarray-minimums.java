class Solution {
    public int sumSubarrayMins(int[] A) {
        int n = A.length;
        
        int[] L = new int[n];
        int[] R = new int[n];
        
        // find range in which A[i] is minimum
        findMinOnLeft(A, L, n);
        findMinOnRight(A, R, n);
        
        long ans = 0;
        int mod = (int) (1e9 + 7);
        
        for(int i = 0; i < n; i++) {
            long left = L[i] % mod;
            long right = R[i] % mod;
            long contri = (A[i] * left * right) % mod;
            ans = (ans % mod + contri % mod) % mod;
        }
        return (int)ans % mod;
        
    }
    
    private void findMinOnLeft(int[] A, int[] L, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && A[stack.peekLast()] >= A[i]) stack.removeLast();
            L[i] = stack.size() == 0 ? i + 1 : i + 1 - (stack.peekLast() + 1);
            stack.addLast(i);
        }
    }
    
    private void findMinOnRight(int[] A, int[] R, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && A[stack.peekLast()] > A[i]) stack.removeLast();
            R[i] = stack.size() == 0 ? n - i : stack.peekLast() - i; // second case : n - i - (stack.peekLast() - i)
            stack.addLast(i);
        }
    }
}
