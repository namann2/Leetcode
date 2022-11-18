class Solution {
    public boolean isUgly(int n) {
        if(n==0) return false;
        while(n%5==0) n/=5;
        while(n%3==0) n/=3;
        while(n%2==0) n/=2;
        return n==1;
    }
}
/*
    The num /= divisor step can only occur log(n) times at most, so it's O(log n) total.
    
    while loop for 2: O(log2 n)

    while loop for 3: O(log3 n)

    while loop for 5: O(log5 n)

    The max is O(log2 n).
*/