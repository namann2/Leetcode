// find the strength of all the subarrays
// we can find the contribution of a particular number 
// number of subarrays where A[i] is the min and what is the sum of those subarrays

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
        
        long answer = 0;
        for(int i=0;i<n;i++) {
            
            answer += (((psps[i+s[i]+1] - psps[i+1]) * e[i]) % mod -
                       ((psps[i+1] - psps[i-e[i]+1]) * s[i]) % mod + mod) % mod * strength[i] % mod;
            answer %= mod;
        }
        return (int)(answer % mod);
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
