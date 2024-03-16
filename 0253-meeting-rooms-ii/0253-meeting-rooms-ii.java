class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Approach 1 
        // TC : O(nlogn), SC : O(n)
        
        /*
        Arrays.sort(intervals, (i1, i2) -> {
            if(i1[0] == i2[0]) return i1[1] - i2[1];
            return i1[0] - i2[0];
        });
        
        int meetingRoom = 0, n = intervals.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        minHeap.offer(intervals[0][1]);
        for(int i = 0; i < n; i++) {
            if(!minHeap.isEmpty() && intervals[i][0] < minHeap.peek()) {
                meetingRoom++;
                minHeap.offer(intervals[i][1]);
            } else {
                minHeap.remove();
            }
        }
        return meetingRoom;
        */
        // Approach 2
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
        
        int meetingRoom = 0, startIndex = 0, endIndex = 0;
        while(startIndex < n) {
            if(start[startIndex] < end[endIndex]) {
                meetingRoom++;
                startIndex++;
            } else {
                startIndex++;
                endIndex++;
            }
        }
        return meetingRoom;
    }
}