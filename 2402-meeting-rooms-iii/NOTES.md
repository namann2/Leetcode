Solution : 

```
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // sort based on the start time 
        Arrays.sort(meetings, (meeting1, meeting2) -> {
            return meeting1[0] - meeting2[0];
        });
        
        int meetingsCount = meetings.length;
        // we want the rooms in sorted order :: from smallest to largest as per availability
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++)
            availableRooms.offer(i);
        
        // meetingRoom, endTimeOfCurrentMeeting
        PriorityQueue<int[]> occupiedRooms = new PriorityQueue<>((info1, info2) -> {
            return info1[1] == info2[1] ? info1[0] - info2[0] : info1[1] - info2[1];
        });
        
        int[] meetingRooms = new int[n];
        
        for(int i = 0; i < meetingsCount; i++) { // i corresponds to the time
            int[] currMeeting = meetings[i];
            // whether any meeting room is going to be vacant at this hour
            while(!occupiedRooms.isEmpty() && occupiedRooms.peek()[1] < currMeeting[0]) {
                // finish the current meeting and add rooms to the available rooms
                availableRooms.offer(occupiedRooms.poll()[0]); 
            }
            // check if current meeting can be held in any of the available Rooms
            if(!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                meetingRooms[room]++;
                occupiedRooms.offer(new int[]{room, currMeeting[1] - 1});
            } else {
                int[] earliestAvailableRoom = occupiedRooms.poll();
                meetingRooms[earliestAvailableRoom[0]]++;
                occupiedRooms.offer(new int[]{earliestAvailableRoom[0], earliestAvailableRoom[1] + currMeeting[1] - 1 - currMeeting[0] + 1});
            }
        }
        
        int roomWithMaxMeetings = -1;
        for(int room = 0; room < n; room++) {
            if(roomWithMaxMeetings == -1 || meetingRooms[room] > meetingRooms[roomWithMaxMeetings]) {
                roomWithMaxMeetings = room;
            }
        }
        
        return roomWithMaxMeetings;
    }
}
```
