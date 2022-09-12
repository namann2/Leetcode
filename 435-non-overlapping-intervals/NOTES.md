# Hint :
**if two intervals are overlapping, we want to remove the interval that has the longer end point -- the longer interval will always overlap with more or the same number of future intervals compared to the shorter one**
​
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