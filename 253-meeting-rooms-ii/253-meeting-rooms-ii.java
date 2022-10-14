// Approach 1 : Sweep Line Algorithm
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length, max = 0;
        
        for(int[]interval : intervals)
            max = Math.max(max, interval[1]);
        
        int[]ps = new int[max+1];
        for(int[] interval : intervals)
        {
            int start = interval[0], end = interval[1];
            ps[start] += 1;
            ps[end] -= 1;
        }
        int ans = 0;
        for(int i=1;i<max+1;i++)
        {
            ps[i] += ps[i-1];
            ans = Math.max(ps[i], ans);
        }
        return ans;
    }
}

//  Approach 2 : Focus on meeting that start early and ends early to minimize the number of meeting rooms required

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2)->{
            return i1[0] - i2[0];
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> {
            return i1[1] - i2[1];
        });
        
        pq.add(intervals[0]);
        int n = intervals.length;
        
        for(int i=1;i<n;i++) {
            int[] goingOn = pq.poll();
            if(intervals[i][0] >= goingOn[1]) goingOn[1] = intervals[i][1];
            else pq.add(intervals[i]);
            pq.add(goingOn);
        }
        return pq.size();
    }
}

// Approach 3 : Another way of performing line sweep

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[]start = new int[n], end = new int[n];
        int p=0;
        for(int[] interval : intervals) {
            start[p] = interval[0];
            end[p++] = interval[1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int meetingRooms = 1, 
        i = 0;
        for(int j=1;j<n;j++) {
            if(start[j] >= end[i]) i++;
            else meetingRooms ++;
        }
        return meetingRooms;
    }
}
