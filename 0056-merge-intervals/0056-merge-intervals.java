class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            return i1[0] - i2[0];
        });
        List<int[]> answer = new ArrayList<>();
        answer.add(intervals[0]);
        
        int n = intervals.length;
        for(int i = 1; i < n; i++) {
            int csize = answer.size();
            int last_end = answer.get(csize - 1)[1];
            int curr_start = intervals[i][0];
            if(last_end >= curr_start) {
                last_end = Math.max(last_end, intervals[i][1]);
                int[] newInterval = {answer.get(csize-1)[0], last_end};;
                answer.set(csize-1, newInterval);
            } else answer.add(intervals[i]);
        }
        
        int index = 0;
        int[][]A = new int[answer.size()][2];
        for(int[] interval : answer) {
            A[index++] = interval;
        }
        return A;
    }
}