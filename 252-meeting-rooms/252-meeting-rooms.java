class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            if(i1[0] == i2[0])
                return i1[1] - i2[1];
            return i1[0] - i2[0];
        });
        
        int n = intervals.length;
        for(int i=1;i<n;i++) {
            if(intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;
    }
}