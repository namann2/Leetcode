## Approach 1 : 
Find the edit distance of two strings and check if it is equal to 1

It is an ok approach but has some downside : 
1. TC and SC

```
class Solution {
    public int minDistance(String A, String B) {
        if(A.equals(B))
            return 0;
        int n = A.length(), m = B.length();
        int[][]dp = new int[n+1][m+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return min_edit_distance(A, B, n-1, m-1, dp) == 1;
    }
    private int min_edit_distance(String A, String B, int i, int j, int [][]dp) {
        // base case
        if(j < 0) return i+1; // deletion
        if(i < 0) return j+1; // insertion
        if(dp[i][j] != -1) 
            return dp[i][j];
        // main logic
        if(A.charAt(i) == B.charAt(j)) {
            return dp[i][j] = min_edit_distance(A, B, i-1, j-1, dp);
        } else {
            int insert = 1 + min_edit_distance(A, B, i, j-1, dp);
            int delete = 1 + min_edit_distance(A, B, i-1, j, dp);
            int replace = 1 + min_edit_distance(A, B, i-1, j-1, dp);

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
}

```
