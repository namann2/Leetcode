class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // if two intervals are overlapping, we want to remove the interval that has the longer end point -- the longer interval will always overlap with more or the same number of future intervals compared to the shorter one
        Arrays.sort(intervals, (i1, i2) -> {
            return i1[0] - i2[0];
        });
        
        int n = intervals.length, overlap = 0;
        for(int curr = 1; curr < n; curr++) {
            int prev = curr-1;
            if(intervals[curr][0] < intervals[prev][1]) {
                overlap++;
                intervals[curr][1] = Math.min(intervals[prev][1], intervals[curr][1]);
            }
        }
        return overlap;
    }
}