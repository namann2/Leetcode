class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // there are three places where we can insert the newInterval
        // 1. begining : 
        //          newInterval will be before 0th index if start time of new Interval 
        //          is earlier than what is present at 0th index
        // 2. somewhere in the middle
        // 3. end
        List<int[]> answer = new ArrayList<>();
        int n = intervals.length;
        int it = 0;
        
        // case 1 and case 2
        while(it < n) {
            if(intervals[it][0] > newInterval[0]) answer.add(newInterval);
            answer.add(intervals[it++]);
        }
        
        // case 3
        if(answer.size() == n) answer.add(newInterval);
        return merged(answer);
    }

    private int[][] merged(List<int[]> list) {
        List<int[]> result = new ArrayList<>();
        int n = list.size();
        for(int i=0;i<n;i++) {
            if(result.size() == 0) result.add(list.get(i));
            else {
                int size = result.size()-1;
                int[] last = result.get(size);
                if(last[1] >= list.get(i)[0]) {
                    last[1] = Math.max(last[1], list.get(i)[1]);
                    result.set(size, last);
                }
                else result.add(list.get(i));
            }
        }
        int idx = 0;
        int[][] answer = new int[result.size()][2];
        for(int[] l : result)
            answer[idx++] = l;
        return answer;
    }
}