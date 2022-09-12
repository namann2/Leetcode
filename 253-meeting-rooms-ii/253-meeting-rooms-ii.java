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