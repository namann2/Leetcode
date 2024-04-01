class Solution {
    public int minimumEffortPath(int[][] heights) {
        // min(maxium values) = binary search
        int n = heights.length, m = heights[0].length;
        int start = 0, end = 1000_000, ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(isValid(heights, heights[0][0], 0, 0, n, m, new boolean[n][m], mid)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
    private boolean isValid(int[][]matrix, int lastHeight, int i, int j, int n, int m, boolean[][]vis, int maxDiff) {
        // main condition
        boolean isCurrentCellSafe = isSafe(matrix, i, j, n, m, maxDiff, vis, lastHeight);
        boolean result = false;
        if(isCurrentCellSafe) {
            // the last cell has to be safe in order to reach with the following path
            if(i == n-1 && j == m-1)
                return true;
            
            vis[i][j] = true;
            result = isValid(matrix, matrix[i][j], i, j-1, n, m, vis, maxDiff) ||
                            isValid(matrix, matrix[i][j], i, j+1, n, m, vis, maxDiff) ||
                            isValid(matrix, matrix[i][j], i-1, j, n, m, vis, maxDiff) ||
                            isValid(matrix, matrix[i][j], i+1, j, n, m, vis, maxDiff);
        }
        return result;
    }
    private boolean isSafe(int[][]matrix, int i, int j, int n, int m, int T, boolean[][]vis, int lastHeight) {
        if(i >= 0 && i < n && j >= 0 && j < m 
           && !vis[i][j] && Math.abs(matrix[i][j] - lastHeight) <= T)
            return true;
        return false;
    }
}