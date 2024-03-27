class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int tl = j-1 >= 0 ? matrix[i-1][j-1] : Integer.MAX_VALUE;
                int ab = matrix[i-1][j];
                int tr = j+1 < m ? matrix[i-1][j+1] : Integer.MAX_VALUE;
                matrix[i][j] += Math.min(tl, Math.min(ab, tr));
            }
        }
        int min = matrix[n-1][0];
        for(int j = 0; j < m; j++) {
            min = Math.min(min, matrix[n-1][j]);
        }
        return min;
    }
}