# Interval Problems :
Approaches :
1. Line Sweep Algorithm
* Create two arrays`start` and `end` that signifies the meeting start and end times
* Sort them. What does the sort signifies ?
* The meeting that starts early and the meeting that ends early
* Check for overlapping
​
2.ScanLine Algorithm
*     Since we want to signify that a range is already occupied by x number meetings, it can also be stated as the we want that specific range to be updated in linear time. This is done by scanline algorithm ( which is as straight as prefix sum )
*   Create a `ps (prefix sum)` array and update the range of start and end of the interval by `+1` && `-1`
*   Do a prefix sum on the array `ps` and see the maximum value we have - that represents the number of meeting rooms we need to accomate the overlapping meetings, the other non-overlapping meetings would be taken care of themselves.
​
​
# Solution 1 : Line Sweep
```
class Solution {
public int minMeetingRooms(int[][] intervals) {
int n = intervals.length;
int[]start = new int[n];