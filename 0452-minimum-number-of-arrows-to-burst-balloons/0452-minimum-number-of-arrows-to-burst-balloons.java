class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (p1, p2) -> {
            return Integer.compare(p1[1], p2[1]); // smaller end point
        });
        int minArrows = 1;
        int[] shootingAt = points[0];
        for(int i=1;i<n;i++) {
            int[] currBallon = points[i];
            if(currBallon[0] > shootingAt[1]) {
                minArrows++;
                shootingAt = currBallon;
            }
        }
        return minArrows;
    }
}