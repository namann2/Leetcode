// Sorting : TC : O(nlogn), SC : O(1)
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            if(i1[0] == i2[0])
                return i1[1] - i2[1];
            return i1[0] - i2[0];
        });
        
        int n = intervals.length;
        for(int i=1;i<n;i++) {
            if(intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;
    }
}

// Line Sweep : TC : O(n), SC : O(n)
// if there is an overlap in the meeting times, then all meetings can not be attended
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int[]line_sweep = new int[(int)1e6+1];
        for(int[] interval : intervals) {
            line_sweep[interval[0]] += 1;
            line_sweep[interval[1]] -= 1;
        }
        
        if(line_sweep[0] > 1) return false;
        
        for(int i = 1; i < line_sweep.length; i++) {
            line_sweep[i] += line_sweep[i-1];
            if(line_sweep[i] > 1) return false;
        }
        return true;
    }
}
