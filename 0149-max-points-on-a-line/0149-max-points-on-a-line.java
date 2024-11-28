class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n == 1) 
            return 1;
        
        int maxPointsOnLine = 0;
        Map<Double, Integer> pointsOnSameLine = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int[] point1 = points[i];
            for(int j = i+1; j < n; j++) {
                int[] point2 = points[j];
                Double slope = findSlope(point1, point2);
                pointsOnSameLine.put(slope, pointsOnSameLine.getOrDefault(slope, 0) + 1);
                maxPointsOnLine = Math.max(maxPointsOnLine, pointsOnSameLine.get(slope));
            }
            pointsOnSameLine.clear();
        }
        return maxPointsOnLine + 1;
    }
    
    private Double findSlope(int[] p1, int[] p2) {
        int x1 = p1[0], y1 = p1[1];
        int x2 = p2[0], y2 = p2[1];
        
        if(x1 == x2) return Double.POSITIVE_INFINITY;
        if(y1 == y2) return 0D;
        return (double)(y2 - y1) / (double)(x2 - x1);
    }
}