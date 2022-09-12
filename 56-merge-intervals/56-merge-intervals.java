class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        return mergeIntervals(intervals);
    }
    private int[][] mergeIntervals(int[][]intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> {
            return i1[0] - i2[0];
        });
        
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