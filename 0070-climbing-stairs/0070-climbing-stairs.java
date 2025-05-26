class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int prevOne = 2, prevTwo = 1;
        // prevTwo, prevOne, currWay
        //          prevTwo, prevOne, currWay
        for(int i = 3; i <= n; i++) {
            int currWay = prevOne + prevTwo;
            prevTwo = prevOne;
            prevOne = currWay;
        }
        return prevOne;
    }
}