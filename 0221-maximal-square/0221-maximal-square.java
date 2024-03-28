class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int max_side = 0;
        int[]next = new int[m];
        for(int i=n-1;i>=0;i--) {
            int[] curr = new int[m];
            for(int j=m-1;j>=0;j--) {
                if(i == n-1 || j == m-1) curr[j] = matrix[i][j] - '0';
                else {
                    if(matrix[i][j] == '0') continue;
                    curr[j] = 1 + Math.min(curr[j+1], Math. min(next[j], next[j+1]));
                }
                max_side = Math.max(max_side, curr[j]);
            }
            next = curr;
        }
        return max_side * max_side;
    }
}