class Solution {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int[]e = endingAt(strength);
        int[]s = startingAt(strength);
        int mod = (int)1e9+7;
        
        long[]ps = new long[n+1];
        for(int i=1;i<n+1;i++)
            ps[i] = (ps[i-1] % mod + strength[i-1] % mod) % mod;
        
        long[]psps = new long[n+2];
        for(int i=1;i<n+2;i++)
            psps[i] = (psps[i-1] % mod + ps[i-1] % mod) % mod;
        
        long answer = 0;
        for(int i=0;i<n;i++) {
            long v1 = e[i] % mod * (psps[i+s[i]+1] - psps[i+1]) % mod;
            long v2 = s[i] % mod * (psps[i+1] - psps[i-e[i]+1]) % mod;
            answer += (((v1 - v2 + mod) % mod) * strength[i]) % mod;
            answer %= mod;
        }
        return (int)(answer % mod);
    }
    private int[] endingAt(int[]A) {
        int n = A.length;
        int[]answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]) stack.pop();
            answer[i] = stack.size() == 0 ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return answer;
    }
    private int[] startingAt(int[] A) {
        int n = A.length;
        int[]answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) stack.pop();
            answer[i] = stack.size() == 0 ? n - i : stack.peek() - i;
            stack.push(i);
        }
        return answer;
    }
}