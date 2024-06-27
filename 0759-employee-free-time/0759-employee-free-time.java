/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // update the treemap
        TreeMap<Integer, Integer> map = new TreeMap<>(); // Key: time point, value: score.
        for (List<Interval> list : schedule) {
            for (Interval interval : list) {
                map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
                map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
            }
        }
        
        int score = 0, start = -1;
        List<Interval> answer = new ArrayList<>();
        
        for(int time : map.keySet()) {
            score += map.get(time);
            if(score == 0 && start == -1) {
                start = time;
            } else if(score != 0 && start != -1) {
                answer.add(new Interval(start, time));
                start = -1;
            }
        }
        return answer;
    }
}