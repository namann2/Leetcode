class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> intervalsList = new ArrayList<>();
        for(int[] interval : intervals)
            intervalsList.add(interval);
        
        intervalsList.add(newInterval);
        
        Collections.sort(intervalsList, (i1, i2) -> {
            return i1[0] - i2[0];
        });
        
        return mergeIntervals(intervalsList);
    }
    
    private int[][] mergeIntervals(List<int[]> intervals) {
        int n = intervals.size();
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals.get(0));
        
        for(int i = 1; i < n; i++) {
            int[] interval = intervals.get(i);
            int lastIndex = merged.size() - 1;
            int[] last = intervals.get(lastIndex);
            // if no overlap in intervals last[0]...last[1]....intervals[0]...intervals[1]
            if(interval[0] > last[1]) 
                merged.add(interval);
            else {
                last[1] = Math.max(interval[1], last[1]);
                merged.set(lastIndex, last);
            }
        }
        n = merged.size();
        int[][] R = new int[n][2];
        
        for(int i = 0; i < n; i++)
            R[i] = merged.get(i);
        
        return R;
    }
}