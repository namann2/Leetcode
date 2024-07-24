class Solution {
    public boolean isPalindrome(int x) {
        // if number is smaller than 0, eg : -121 it is not a palindrome
        if(x < 0) return false;
        // if number's last digit is 0, then to be palindrome, the first digit has to be 0
        // potential follow-up : Are we given correct Integer ? ( 0145 won't be a case ). if so, only valid case is when x is 0
        if(x % 10 == 0 && x != 0) return false;
        // reverse the number and compare
        int revertedNumber = 0, original = x;
        while(x > 0) {
            revertedNumber = (revertedNumber * 10) + (x % 10);
            x /= 10;
        }
        return revertedNumber == original;
    }
}