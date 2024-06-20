class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (i1, i2) -> {
            return i1[0] - i2[0];
        });
        
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        
        for(int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            int[] last = merged.get(merged.size()-1);
            // if no overlap -> last[0]...last[1] .... interval[0].....interval[1]
            if(interval[0] > last[1]) merged.add(interval);
            else {
                last[1] = Math.max(interval[1], last[1]);
                merged.set(merged.size()-1, last);
            }
        }
        
        n = merged.size();
        int[][] R = new int[n][2];
        for(int i = 0; i < n; i++) 
            R[i] = merged.get(i);
        
        return R;
    }
}