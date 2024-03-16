class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int[]line_sweep = new int[(int)1e6+1];
        for(int[] interval : intervals) {
            line_sweep[interval[0]] += 1;
            line_sweep[interval[1]] -= 1;
        }
        
        if(line_sweep[0] > 1) return false;
        
        for(int i = 1; i < line_sweep.length; i++) {
            line_sweep[i] += line_sweep[i-1];
            if(line_sweep[i] > 1) return false;
        }
        return true;
    }
}