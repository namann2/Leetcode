class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        int prev1 = 1, prev2 = 1, curr = 1;
        for(int i=3;i<n+1;i++) {
                curr = prev1 + prev2;
                prev1 = prev2;
                prev2 = curr;
        }
        return curr;
    }
}