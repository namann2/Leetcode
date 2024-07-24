class Solution {
    public int reverse(int x) {
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        long y = 0;
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        while(x > 0) {
            y = y * 10 + x % 10;
            if(min > y || y > max || min > sign * y || sign * y > max)
                return 0;
            x /= 10;
        }
        return ((int)y) * sign;
    }
}