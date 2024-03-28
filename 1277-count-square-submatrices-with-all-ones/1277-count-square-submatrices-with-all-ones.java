class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int cnt = 0;
        int[]next = new int[m];
        for(int i=n-1;i>=0;i--) {
            int[] curr = new int[m];
            for(int j=m-1;j>=0;j--) {
                if(i == n-1 || j == m-1) curr[j] = matrix[i][j];
                else {
                    if(matrix[i][j] == 0) continue;
                    curr[j] = 1 + Math.min(curr[j+1], Math. min(next[j], next[j+1]));
                }
                cnt += curr[j];
            }
            System.out.println(Arrays.toString(curr));
            next = curr;
        }
        return cnt;
    }
}