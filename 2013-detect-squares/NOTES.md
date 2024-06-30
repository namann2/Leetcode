The following approch is acceptable but it can be optimised.

TC: O(M) where M is the number of points.
SC: O(M) where M is the number of points.
```
class DetectSquares {
    
    private Map<String, Integer> pointsCount;
    private List<int[]> points;
    private static String DEL = "#";
    
    public DetectSquares() {
        pointsCount = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        StringBuilder sb = new StringBuilder();
        sb.append(point[0]).append(DEL).append(point[1]);
        String key = sb.toString();
        pointsCount.put(key, pointsCount.getOrDefault(key, 0) + 1);
        points.add(point);
    }
    
    public int count(int[] queryPoint) {
        int px = queryPoint[0], py = queryPoint[1];
        int numWays = 0;
        for(int[] point : points) {
            int qx = point[0], qy = point[1];
            // check diagonal and check if two points form square sides
            if(px != qx && py != qy && Math.abs(px-qx) == Math.abs(py-qy)) {
                String pxqy = new StringBuilder().append(px).append(DEL).append(qy).toString();
                String qxpy = new StringBuilder().append(qx).append(DEL).append(py).toString();
                numWays += pointsCount.getOrDefault(pxqy, 0) * pointsCount.getOrDefault(qxpy, 0);
            }
        }
        return numWays;
    }
}
```

### Optimised : 

https://www.baeldung.com/java-objects-hash-vs-objects-hashcode

TC :  O(N) where N is the number of unique points
SC :  O(N) where N is the number of unique points

```
class DetectSquares {
    
    private Map<Point, Integer> pointsCount;
    
    public DetectSquares() {
        pointsCount = new HashMap<>();
    }
    
    public void add(int[] point) {
        Point p = new Point(point[0], point[1]);
        pointsCount.put(p, pointsCount.getOrDefault(p, 0) + 1);
    }
    
    public int count(int[] queryPoint) {
        int px = queryPoint[0], py = queryPoint[1];
        int numWays = 0;
        for(Point point : pointsCount.keySet()) {
            int qx = point.x, qy = point.y;
            // check diagonal
            if(px != qx && py != qy && Math.abs(px-qx) == Math.abs(py-qy)) {
                Point pxqy = new Point(px, qy);
                Point qxpy = new Point(qx, py);
                numWays += pointsCount.getOrDefault(point, 0) *
                           pointsCount.getOrDefault(pxqy, 0) *
                           pointsCount.getOrDefault(qxpy, 0);
            }
        }
        return numWays;
    }
}

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
    
    @Override
    public boolean equals(Object point) {
        if(this == point) return true;
        Point two = (Point) point;
        if(this.x == two.x && this.y == two.y) return true;
        return false;
    }
}
```
