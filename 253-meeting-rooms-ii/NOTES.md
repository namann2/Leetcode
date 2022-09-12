# Interval Problems : 

Approaches : 

1. Line Sweep Algorithm
	* Create two arrays`start` and `end` that signifies the meeting start and end times
	* Sort them. What does the sort signifies ?
		* The meeting that starts early and the meeting that ends early
	* Check for overlapping


2. ScanLine Algorithm
	* Since we want to signify that a range is already occupied by x number meetings, it can also be stated as the we want that specific range to be updated in linear time. This is done by scanline algorithm ( which is as straight as prefix sum )
	* Create a `ps (prefix sum)` array and update the range of start and end of the interval by `+1` && `-1`
	* Do a prefix sum on the array `ps` and see the maximum value we have - that represents the number of meeting rooms we need to accomate the overlapping meetings, the other non-overlapping meetings would be taken care of themselves.


# Solution 1 : Line Sweep
```
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[]start = new int[n];
        int[]end = new int[n];
        
        for(int i=0;i<n;i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int meetingRoom = 1;
        int prev = 0;
        for(int curr=1;curr<n;curr++) {
            if(start[curr] < end[prev]) meetingRoom++;
            else prev++;
        }
        return meetingRoom;
    }
}
```

# Solution 2 :
```
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int max = 1000001;
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
```


Similar Problem : 

1. https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/
2. https://leetcode.com/problems/shifting-letters-ii/
3. https://leetcode.com/problems/describe-the-painting/
