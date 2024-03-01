### Pepcoding 
```
class Solution {
    public int rob(int[] A) {
        int n = A.length;
        if( n == 1 ) return A[0];
        // leave first
        int inc = A[1], exc = 0;
        for(int i=2;i<n;i++) {
            int ninc = A[i] + exc;
            int nexc = Math.max(inc, exc);
            
            inc = ninc;
            exc = nexc;
        }
        
        int op1 = Math.max(inc, exc);
        
        // leave last
        inc = A[0];
        exc = 0;
        for(int i=1;i<n-1;i++) {
            int ninc = A[i] + exc;
            int nexc = Math.max(inc, exc);
            
            inc = ninc;
            exc = nexc;
        }
        
        int op2 = Math.max(inc, exc);
        
        return Math.max(op1, op2);
    }
}
```
