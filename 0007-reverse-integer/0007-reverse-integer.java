class Solution {
    public int reverse(int x) {
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        long y = 0, sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        while(x > 0) {
            y = y * 10 + x % 10;
            if(min > y || y > max)
                return 0;
            x /= 10;
        }
        long reverseNumber = sign * y * 1l;
        if(min <= reverseNumber && reverseNumber <= max)
            return (int)reverseNumber;
        
        return 0;
    }
}