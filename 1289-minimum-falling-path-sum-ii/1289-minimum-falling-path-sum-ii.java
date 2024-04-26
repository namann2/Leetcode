class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int col = 0; col < grid.length; col++) {
            dp[n - 1][col] = grid[n - 1][col];
        }

        
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int nextMinimum = Integer.MAX_VALUE;
                for (int nextRowCol = 0; nextRowCol < n; nextRowCol++) {
                    if (nextRowCol != col) {
                        nextMinimum = Math.min(nextMinimum, dp[row + 1][nextRowCol]);
                    }
                }

                dp[row][col] = grid[row][col] + nextMinimum;
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            answer = Math.min(answer, dp[0][col]);
        }

        return answer;
    }
}