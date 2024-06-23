public class Solution {
    // you need treat n as an unsigned value
    // Java's primitive integer types (byte, short, int, and long) are all signed.
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            result |= (bit << (31-i));
        }
        return result;
    }
}