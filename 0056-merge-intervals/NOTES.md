// Solution using Comparator
```
class CustomComparator implements Comparator<int[]> {
public int compare(int[] a, int[] b) {
return a[0] - b[0];
}
}
class Solution {
public int[][] merge(int[][] intervals) {
ArrayList<int[]> merged = new ArrayList<>();
Arrays.sort(intervals, new CustomComparator());
for(int[] interval : intervals) {
if(merged.size() == 0) {
merged.add(interval);
} else {
int[] prevInterval = merged.get(merged.size()-1);
if(interval[0] <= prevInterval[1]) {
prevInterval[1] = Math.max(interval[1], prevInterval[1]);
} else {
merged.add(interval);
}
}
}