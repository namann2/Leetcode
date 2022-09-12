*   Do a prefix sum on the array `ps` and see the maximum value we have - that represents the number of meeting rooms we need to accomate the overlapping meetings, the other non-overlapping meetings would be taken care of themselves.
​
​
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
​
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