class Solution {
    public int minBitFlips(int start, int goal) {
        // return Integer.bitCount(start ^ goal);
        int xor = start ^ goal;
        return numberOfBits(xor);
    }
    
    private int numberOfBits(int number) {
        int count = 0;
        while(number > 0) {
            count++;
            number = number & (number-1);
        }
        return count;
    }
}