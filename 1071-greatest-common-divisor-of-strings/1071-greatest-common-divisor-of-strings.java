class Solution {
    public String gcdOfStrings(String A, String B) {
        int n = A.length(), m = B.length();
        if(n < m)
            return gcdOfStrings(B, A);
        
        StringBuilder LHS = new StringBuilder();
        StringBuilder RHS = new StringBuilder();
        
        LHS.append(A).append(B);
        RHS.append(B).append(A);
        
        if(!LHS.toString().equals(RHS.toString())) return "";
        
        int gcd = gcd(n, m);
        return A.substring(0, gcd);
    }
    private int gcd(int a, int b) {
        // base case
        if(a == 0) return b;
        // main logic
       return gcd(b % a, a);
    }
}

/*
    a = 3, b = 18
        3 | 18 | 5
            15
            --
            3 | 3 | 1
                3
                --
                0
*/