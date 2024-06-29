class Solution {
    public int mostBooked(int n, int[][] meetings) {
        /*
            Have a list of available rooms
            Have a list of in-use meeting rooms
            Map -> Meeting room -> count of meetings happened
        */
        
        // can be a map but n can be atmost 100, hence an array is sufficient
        int[] meetingRoomCount = new int[n];
        
        PriorityQueue<Long> availableRooms = new PriorityQueue<>();
        for(long i = 0; i < n; i++)
            availableRooms.offer(i);
        
        // sort meetings by their start times. Those meetings that start early and ends early
        Arrays.sort(meetings, 
                    (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        
        // In-use meeting rooms -> endTime, meetingRoom
        PriorityQueue<long[]> inUseRooms = new PriorityQueue<>((a,b)->{
            return a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]);
        });
        
        int meetingCount = meetings.length;
        for(int i = 0; i < meetingCount; i ++) {
            int[] meeting = meetings[i];
            
            while(!inUseRooms.isEmpty() && inUseRooms.peek()[0] <= meeting[0]) { // equals because endTime is open interval
                availableRooms.offer(inUseRooms.poll()[1]);
            }
            
            // if we have some empty room available
            if(!availableRooms.isEmpty()) { //if(meetingRoom != -1) {
                long meetingRoom = availableRooms.poll();
                meetingRoomCount[(int)meetingRoom]++;
                inUseRooms.offer(new long[]{meeting[1], meetingRoom});
            } else { // no room is available, but we have to find the meetingRoom which can be assigned to this meeting
                long[] earliestRoomAvailable = inUseRooms.poll();
                long earliestTime = earliestRoomAvailable[0], earliestRoom = earliestRoomAvailable[1];
                long currentMeetingEndTime = earliestTime + meeting[1] - meeting[0];
                inUseRooms.offer(new long[]{currentMeetingEndTime, earliestRoom});
                meetingRoomCount[(int)earliestRoom]++;
            }
        }
        
        System.out.println(Arrays.toString(meetingRoomCount));
        
        int maxMeetings = Integer.MIN_VALUE, room = 0;
        for(int i = 0; i < n; i++) {
            if(maxMeetings < meetingRoomCount[i]) {
                maxMeetings = meetingRoomCount[i];
                room = i;
            }
        }
        return room;
    }
}