class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        int idx = 0;
        for(int[] interval : intervals) {
            start[idx] = interval[0];
            end[idx] = interval[1];
            idx++;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int prev = 0, meetingRoom = 1;
        for(int i = 1; i < n; i++) {
            if(start[i] < end[prev]) {
                meetingRoom++;
            } else prev++;
        }
        return meetingRoom;
    }
}