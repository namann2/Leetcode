class Solution {
    public int minDeletionSize(String[] strs) {
        int cols = strs[0].length();
        int cnt = 0;
        int total = strs.length;
        for(int col=0;col<cols;col++) {
            for(int j=1;j<total;j++) {
                String current = strs[j], previous = strs[j-1];
                if(current.charAt(col) < previous.charAt(col)) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}