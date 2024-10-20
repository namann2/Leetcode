class Solution {
    public int[][] construct2DArray(int[] original, int rows, int cols) {
        int[][] ans = new int[rows][cols];
        int n = original.length;
        if(n != rows * cols)
            return new int[][]{};
        for(int index = 0; index < n; index++) {
            int rn = index / cols;
            int cn = index % cols;
            ans[rn][cn] = original[index];
        }
        return ans;
    }
}