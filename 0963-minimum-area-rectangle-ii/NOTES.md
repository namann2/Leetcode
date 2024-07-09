This problem, I found very problematic.<br>

Reasons : 
1. Too much mathematical requirements
2. Even complexity analysis breaks my head.

Anyways, I have tried to some up the complexity to my utmost knowledge and research.

Iterating over each Centre in the map : There are at most O(n^2) centres since each pair of points defines a unique centre.
For each Centre, the nested loops iterate over pairs in point, which has at most O(n) pairs.

Hence : <br>
TC : O(n^4) <br>
SC : O(n^2)

<hr>

<b>This is a loose bound to the solution. How ?</b>

To form a rectangle from n points, we need two pairs of parallel sides. 
This involves specific arrangements and geometric properties of the points, not just any four points.
The number of rectangles formed by n points is generally less than (nC4) 
because not all combinations of four points will form a rectangle.


```
class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        if(n < 4) return 0.0;
        
        HashMap<Centre, List<int[]>> map = new HashMap<>(); 
        
        // O(n^2)
        // build the graph
        for(int i = 0; i < n; i++) {
            int[] x = points[i];
            for(int j = i+1; j < n; j++) {
                int[] y = points[j];
                // centre coordinate for points x and y
                double cx = (x[0] + y[0]) / 2.0;
                double cy = (x[1] + y[1]) / 2.0;
                // distance b/w two points
                double dis_x_y = distanceBetweenPoints(points[i], points[j]);
                Centre c = new Centre(cx, cy, dis_x_y);
                map.putIfAbsent(c, new ArrayList<>());
                map.get(c).add(new int[]{i, j});
            }
        }
        
        double minArea = Double.MAX_VALUE;
        for(Centre c : map.keySet()) { // O(n^2)
            List<int[]> point = map.get(c);
            int size = point.size();
            if(size < 2) continue;
            for(int i = 0; i < size; i++) { // O(n)
                int p1 = point.get(i)[0];
                int p2 = point.get(i)[1];
                for(int j = i+1; j < size; j++) { // O(n)
                    int p3 = point.get(j)[0];
                    int p4 = point.get(j)[1];
                    // p1 and p2 are diagonal points and so is, p3 and p4
                    // note : the order of p1,p2 with p3,p4 does not matter
                    // in any combination of points [p1-p3, p2-p4] or [p1-p4, p2-p3] bcz
                    // we are considering the two different sides of rectangle.
                    double l1 = distanceBetweenPoints(points[p1], points[p3]);
                    double l2 = distanceBetweenPoints(points[p2], points[p4]);
                    double l3 = distanceBetweenPoints(points[p1], points[p4]);
                    double l4 = distanceBetweenPoints(points[p2], points[p3]);
                    if(Math.abs(l1 - l2) <= 0.0000001 && Math.abs(l3 - l4) <= 0.0000001)
                        minArea = Math.min(minArea, l1 * l3);
                }
            }
        }
        return minArea == Double.MAX_VALUE ? 0.0 : minArea;
    }
    
    private double distanceBetweenPoints(int[] x, int[] y) {
        return Math.sqrt(((x[0] - y[0]) * (x[0] - y[0])) + ((x[1] - y[1]) * (x[1] - y[1])));
    }
}

class Centre {
    double cx, cy, dis;
    public Centre(double cx, double cy, double dis) {
        this.cx = cx;
        this.cy = cy;
        this.dis = dis;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.cx, this.cy, this.dis);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        Centre c2 = (Centre) obj;
        return this.cx == c2.cx && this.cy == c2.cy && this.dis == c2.dis;
    }
}

```
