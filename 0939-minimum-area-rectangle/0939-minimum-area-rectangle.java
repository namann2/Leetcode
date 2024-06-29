class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> mappingOfPoints = new HashMap<>();
        
        for(int[] point : points) {
            mappingOfPoints.putIfAbsent(point[0], new HashSet<>());
            mappingOfPoints.get(point[0]).add(point[1]);
        }
        
        // System.out.println(mappingOfPoints);
        
        int n = points.length;
        int A = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int a[] = points[i];
            for(int j = i+1; j < n; j++) {
                int b[] = points[j];
                if(b[1] != a[1] && b[0] != a[0]) { // diagonal
                    if(mappingOfPoints.get(b[0]).contains(a[1]) && mappingOfPoints.get(a[0]).contains(b[1]))
                        A = Math.min(A, Math.abs(b[0] - a[0]) * Math.abs(b[1] - a[1]));
                }
            }
        }
        return A == Integer.MAX_VALUE ? 0 : A;
    }
}