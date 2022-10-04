Helpful for the condition : https://leetcode.com/problems/sum-of-total-strength-of-wizards/discuss/2062017/C%2B%2B-prefix-%2B-monotonic-stack-O(N)-solution-with-thought-process


# Thought Process : 
We need to get the contribution of A[i] as the minimum element in the subarray.
We can get the number of arrays where A[i] is the minimum ( can be solved using monotonic stack )
The only dead-end is to find the summation of the subarrays where A[i] is the minimum element.

```

class Solution {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int mod = (int)1e9+7;
        int[]s = new int[n];
        int[]e = new int[n];
        startingAt(strength, s);
        endingAt(strength, e);
        
        long[] ps = new long[n+1];
        for(int i=1;i<n+1;i++) ps[i] = strength[i-1] % mod + ps[i-1] % mod;
        
        long[]psps = new long[n+2];
        for(int i=1;i<n+2;i++) psps[i] = (ps[i-1] % mod + psps[i-1] % mod) % mod;
        
        // System.out.println(Arrays.toString(strength));
        // System.out.println(Arrays.toString(s));
        // System.out.println(Arrays.toString(e)); 
        // System.out.println(Arrays.toString(psps));
        
        long ts = 0;
        for(int i=0;i<n;i++) {  
            long x1 = psps[i+s[i]+1];
            long x2 = psps[i+1];
            long ex = e[i];
            long y1 = psps[i-e[i]+1];
            long sx = s[i];
            long one = ((x1 - x2) * ex) % mod ;
            long two = ((x2 - y1) * sx) % mod;
            
            // System.out.println("one : "+one);
            // System.out.println("two : "+two);
            // System.out.println("x1 : "+x1);
            // System.out.println("x2 : "+x2);
            // System.out.println("ex : "+ex);
            // System.out.println("y1 : "+y1);
            // System.out.println("sx : "+sx);
            // System.out.println();
            ts += ((one - two + mod) % mod * strength[i]) % mod;
            ts %= mod;
        }
        return (int)(ts % mod);
    }
    
    private void startingAt(int[] A, int[] s) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) stack.pop();
            s[i] = stack.size() == 0 ? n-i : stack.peek() - i;
            stack.push(i);
        }
    }
    
    private void endingAt(int[] A, int[] e) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]) stack.pop();
            e[i] = stack.size() == 0 ? i+1 : i - stack.peek();
            stack.push(i);
        }
    }
}
```


positives : 
ps[i] * 5
ps[i+1] * 5
ps[i+2] * 5
ps[i+3] * 5

5 * (ps[i] + ps[i+1] + ps[i+2] + ps[i+3]) ~ 5 * (pps[i+3] - pps[i-1]) ~ 5 * (pps[i + st[i] - 1] - pps[i-1])

negatives : 
ps[-1] * 4
ps[0] * 4
ps[1] * 1
ps[2] * 1
ps[3] * 1
ps[i-1] * 3
ps[i-2] * 3
ps[i-3] * 3


4 * ps[-1] ~ 0
ps[0] + ps[1] + ps[2] + ps[3] ~ ps[i-1]
3 * (ps[0] + ps[i-1] + ps[i-2] + ps[i-3]) ~ i - en[i]



                        3 4 5 6 1 3 4 5 1
                    st= 4 3 2 1 4 3 2 1 1
                    en= 1 1 1 1 5 1 1 1 9
                   
                   0 1 2 3 4 5 6 7 8
                   3 4 5 6 1 3 4 5 1
                 0         ^
    3,4,5,6,1    -         +            ps[i] - ps[-1]
    4,5,6,1        -       +            ps[i] - ps[0]
    5,6,1            -     +            ps[i] - ps[1]
    6,1                -   +            ps[i] - ps[2]
    1                    - +            ps[i] - ps[3]
    1,3                  -   +          ps[i+1] - ps[i-1]
    1,3,4                -     +        ps[i+2] - ps[i-1]
    1,3,4,5              -       +      ps[i+3] - ps[i-1]
    6,1,3              -      +         ps[i+1] - ps[i-2]
    6,1,3,4            -         +      ps[i+2] - ps[i-2]
    6,1,3,4,5          -           +    ps[i+3] - ps[i-2]
    5,6,1,3          -        +         ps[i+1] - ps[i-3]
    5,6,1,3,4        -          +       ps[i+2] - ps[i-3]
    5,6,1,3,4,5      -            +     ps[i+3] - ps[i-3]
    4,5,6,1,3        -        +         ps[i+1] - ps[0]
    4,5,6,1,3,4     -            +      ps[i+2] - ps[0]
    4,5,6,1,3,4,5                       ps[i+3] - ps[0]
    3,4,5,6,1,3                         ps[i+1] - ps[-1]
    3,4,5,6,1,3,4                       ps[i+2] - ps[-1]
    3,4,5,6,1,3,4,5                     ps[i+3] - ps[-1]
    
