class Solution {
    public int minFlipsMonoIncr(String s) {
        /*
            Tried counting zeros instead of ones but the logic did not work !
            Why ?
            For eg : 1 0 0 1
            We would skip the 1 at 0th index since the count of zero is 0.
            which would fasilfy the condition we want i.e. 0....0..1...1
            
            Hence, we move to count ones
        */
        int n = s.length();
        int cnt = 0;
        int ones = 0;
        for(int i = 0 ;i < n ; i ++) {
            int num = s.charAt(i)-'0';
            if(num == 1) ++ones;
            else cnt = Math.min(cnt + 1, ones);
        }
        return cnt;
    }
}
