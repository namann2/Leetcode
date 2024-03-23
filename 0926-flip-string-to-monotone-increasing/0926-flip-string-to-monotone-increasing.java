class Solution {
    public int minFlipsMonoIncr(String s) {
        // greedy
        int n = s.length();
        int ones = 0, flips = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '1') ones++;
            else {
               flips = Math.min(ones, 1 + flips); 
            }
        }
        return flips;
    }
}