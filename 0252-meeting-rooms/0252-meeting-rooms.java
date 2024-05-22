class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return true;
        Arrays.sort(intervals, (i1, i2) -> {
            if(i1[0] == i2[0])
                return i1[1] - i2[1];
            return i1[0] - i2[0];
        });
        
        int meetingRoom = 1, endTime = intervals[0][1];
        int n = intervals.length;
        for(int i = 1; i < n; i++) {
            if(intervals[i][0] < endTime) {
                return false;
            } else endTime = Math.max(endTime, intervals[i][1]);
        }
        return true ;
    }
}