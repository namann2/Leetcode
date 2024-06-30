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
            // check diagonal
            if(px != qx && py != qy && Math.abs(px-qx) == Math.abs(py-qy)) {
                String pxqy = new StringBuilder().append(px).append(DEL).append(qy).toString();
                String qxpy = new StringBuilder().append(qx).append(DEL).append(py).toString();
                numWays += pointsCount.getOrDefault(pxqy, 0) * pointsCount.getOrDefault(qxpy, 0);
            }
        }
        return numWays;
    }
}