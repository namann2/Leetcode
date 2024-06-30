```
class DetectSquares {
private HashMap<String, Integer> counts;
private List<int[]> points;
public DetectSquares() {
this.counts = new HashMap<>();
this.points = new ArrayList<>();
}
// TC : O(1)
public void add(int[] point) {
String key = point[0] + "-" + point[1];
counts.put(key, counts.getOrDefault(key, 0)+1);
points.add(point);
}
// TC : O(num of points before calling count)
public int count(int[] point) {
int ans = 0;
int px = point[0], py = point[1];
for(int[] p : points) {
int x = p[0], y = p[1];
if(x == px || y == py || Math.abs(px-x) != Math.abs(py-y))
continue;