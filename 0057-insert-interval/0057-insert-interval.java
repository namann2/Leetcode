class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        
        // insert in begining and middle
        int it = 0;
        while(it < n) {
            // insertion based on start time of the interval
            if(newInterval[0] < intervals[it][0]) ans.add(newInterval);
            ans.add(intervals[it++]);
        }
        
        // insert at end
        if(ans.size() == n) ans.add(newInterval);
        return mergeIntervals(ans);
    }
    
    private int[][] mergeIntervals(List<int[]> intervals) {
        int n = intervals.size();
        List<int[]> merged = new ArrayList<>();
        
        merged.add(intervals.get(0));
        for(int i = 1; i < n; i++) {
            int[] interval = intervals.get(i);
            int lastIndex = merged.size() - 1;
            int[] last = merged.get(lastIndex);
            // if no overlap ..last[0]...last[1]...interval[0]..interval[1]
            if(interval[0] > last[1]) merged.add(interval);
            else {
                last[1] = Math.max(interval[1], last[1]);
                merged.set(lastIndex, last);
            }
        }
        
        n = merged.size();
        int[][] R = new int[n][2];
        int idx = 0;
        for(int i = 0; i < n; i++)
            R[i] = merged.get(i);
        
        return R;
    }
}