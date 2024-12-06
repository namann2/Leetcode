class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int cntOfNegElements = 0, minElement = Integer.MAX_VALUE;
        long summation = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] < 0)
                    cntOfNegElements++;
                summation += Math.abs(matrix[i][j]);
                minElement = Math.min(minElement, Math.abs(matrix[i][j]));
            }
        }
        // even number of neg elements
        if((cntOfNegElements % 2) == 0) return summation;
        // https://leetcode.com/problems/maximum-matrix-sum/discuss/1417606/C++-The-basic-idea-is-to-eliminate-negative-signs/1056027
        return summation - 2*minElement;
    }
}