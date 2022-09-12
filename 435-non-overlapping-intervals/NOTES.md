# Hint :
**if two intervals are overlapping, we want to remove the interval that has the longer end point -- the longer interval will always overlap with more or the same number of future intervals compared to the shorter one**

****
# Way 1 : 
```
class Pair {
    int s, e;
    Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((i1, i2) -> {
            return i1.e - i2.e;
        });
        
        for(int[] interval : intervals) {
            pq.add(new Pair(interval[0], interval[1]));
        }
        
        int count = 1;
        Pair get = pq.poll();
        int m_e = get.e; // max end time
        while(!pq.isEmpty()) {
            get = pq.poll();
            if(get.s >= m_e) {
                count++;
                m_e = get.e;
            }
        }
        
        return intervals.length-count;
    }
}
```

# Sol 2 : 

```
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int n = intervals.length;
        
        if(n == 1) return 0;
        
        Arrays.sort(intervals, (a, b)->{
           return Integer.compare(a[1], b[1]); 
        });
        
        // We are calculating the "NON - OVERLAPPING" Seq
        int num = 1;
        int max_end = intervals[0][1];
        for(int i=1;i<n;i++) {
            if(intervals[i][0] >= max_end) {
                max_end = intervals[i][1];
                num++;
            }
        }
        return n-num;
    }
}
```

# Way 3 : 
```
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            if(i1[0] == i2[0]) 
                return i1[1] - i2[1];
            return i1[0] - i2[0];
        });
        
        int i = 0, cnt = 0;
        int n = intervals.length;
        for(int j=1;j<n;j++) {
            // no overlap
            if(intervals[j][0] >= intervals[i][1])
            {
                i = j;
            }
            else {
                // overlap
                cnt++;
                // remove that interval which has higher value of end because 
                // two intervals are overlapping, we want to remove the interval 
                // that has the longer end point -- 
                // the longer interval will always overlap with more or 
                // the same number of future intervals compared to the shorter one
                intervals[i][1] = Math.min(intervals[i][1], intervals[j][1]);
            }
        }
        
        return cnt;
    }
}
```
