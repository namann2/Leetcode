There are two ways to solve this :
1. Line sweep
2. PqriorityQueue
​
​
# Line sweep :
Create start and end time arrays and compare using pointers. Why does this work ?
We are only conserned about the room being empty and not interested in exactly which room does get vacant.
​
```
class Solution {
public int minMeetingRooms(int[][] intervals) {
int n = intervals.length, meetingRoom = 1, minRoom = 1;
int [] start = new int[n], end = new int[n];
int p = 0;
for(int[] interval : intervals) {
start[p] = interval[0];
end[p] = interval[1];
p++;
}
Arrays.sort(start);
Arrays.sort(end);