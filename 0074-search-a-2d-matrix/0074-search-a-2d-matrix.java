class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int start = 0, end = rows * cols - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / cols, j = mid % cols;
            if(matrix[i][j] == target) return true;
            else if(target > matrix[i][j]) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return false;
    }
}