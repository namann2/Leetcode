class Solution {
    public int sumSubarrayMins(int[] A) {
        int n = A.length;
        int[] L = new int[n];
        int[] R = new int[n];
       
        findNextSmallerOnLeft(A, L, n);
        findNextSmallerOnRight(A, R, n);
        
        long ans = 0;
        int mod = (int)(1e9 + 7);
        
        // System.out.println(Arrays.toString(L));
        // System.out.println(Arrays.toString(R));
        
        for(int i = 0; i < n; i++) {
            long l = L[i] % mod;
            long r = R[i] % mod;
            ans += (l * r * A[i]) % mod;
            ans %= mod;
        }
        return (int)(ans % mod);
    }
    
    private void findNextSmallerOnLeft(int[] A, int[] L, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && A[stack.peekLast()] >= A[i]) stack.removeLast();
            L[i] = stack.isEmpty() ? i + 1 : i - stack.peekLast();
            stack.addLast(i);
        }
    }
    
    private void findNextSmallerOnRight(int[] A, int[] R, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && A[stack.peekLast()] > A[i]) stack.removeLast();
            R[i] = stack.isEmpty() ? n - i : stack.peekLast() - i;
            stack.addLast(i);
        }
    }
}

/*

    3 1 2 4
    
    3   3 1     3 1 2   3 1 2 4
    1   1 2     1 2 4
    2   2 4
    4
    
    10. 4           2       1
    
    
    
    3 1 2 4
    0 1 2 3
    
   -1-1 1 3
    1 4 4 4
    
    2 
    
*/