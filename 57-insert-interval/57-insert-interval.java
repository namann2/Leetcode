class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> all = new ArrayList<>();
        int n = intervals.length, i = 0;
        // Two edge cases : inserting at 0th index and nth index
        if(n == 0) return new int[][]{newInterval};
        
        while(i < n) {
            if(intervals[i][0] > newInterval[0]) all.add(newInterval);
            all.add(intervals[i]);
            i++;
        }
        
        if(n == all.size()) all.add(newInterval);
        
        return mergeIntervals(all);
    }
    
    private int[][] mergeIntervals(List<int[]> intervals) {
        List<int[]> merged = new ArrayList<>();
        for(int[] interval : intervals) {
            if(merged.size() == 0) merged.add(interval);
            else {
                int size = merged.size()-1;
                int[] last = merged.get(size);
                if(interval[0] <= last[1]) {
                    last[1] = Math.max(last[1], interval[1]);
                    merged.set(size, last);
                } else merged.add(interval);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}