class Solution {
    public int reverse(int x) {
        long y = 0, sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        while(x > 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        long reverseNumber = sign * y * 1l;
        
        if(Integer.MIN_VALUE <= reverseNumber && reverseNumber <= Integer.MAX_VALUE)
            return (int)reverseNumber;
        
        return 0;
    }
}