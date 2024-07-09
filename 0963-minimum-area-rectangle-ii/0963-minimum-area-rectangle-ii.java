class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        if(n < 4) return 0.0;
        
        HashMap<Centre, List<int[]>> map = new HashMap<>(); 
        
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
        
        // System.out.println(map);
        double minArea = Double.MAX_VALUE;
        for(Centre c : map.keySet()) {
            List<int[]> point = map.get(c);
            int size = point.size();
            if(size < 2) continue;
            for(int i = 0; i < size; i++) {
                int p1 = point.get(i)[0];
                int p2 = point.get(i)[1];
                for(int j = i+1; j < size; j++) {
                    int p3 = point.get(j)[0];
                    int p4 = point.get(j)[1];
                    // p1 and p2 are diagonal points and so is, p3 and p4
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