class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        transpose(matrix, n, m);
        inverse(matrix, n, m);
    }
    
    private void transpose(int[][] matrix, int n, int m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i < j) continue;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    private void inverse(int[][] matrix, int n, int m) {
        int left = 0, right = m - 1;
        while(left < m/2) {
            for(int i = 0; i < n; i++) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
        }
    }
    
    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}