class Solution {
    public int tribonacci(int n) {
        if(n <= 1) return n;
        int a = 0, b = 1, c = 1;
        for(int i = 3;i<n+1;i++) {
            int curr = c + b + a;
            a = b;
            b = c;
            c = curr;
        }
        return c;
    }
}