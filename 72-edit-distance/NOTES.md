# Thought Process : 

We need to find the min number of operation that needs to be done to convert string 1 to string 2.

Possible options : 
1. Brute Force ( would work, since n = 500 ) but brute force would be tough
2. DP ( would work since, we could define our dp state clearly )
3. Binary Search
4. BFS
5. Greedy

dp state -> min number of operations that needs to be done at `w1[i]` && `w2[j]` so that the string becomes equal.
Now as there are three operations that could be done, we would check the min out of them.

base cases : 
1. w1 could be empty  = we need to insert
2. w2 could be empty  = we need to delete

Hence, base cases

```
        int[][]dp = new int[n+1][m+1];

        for(int i=0;i<n+1;i++) 
            dp[i][0] = i;
        
        for(int j=0;j<m+1;j++)
            dp[0][j] = j;
```

# Complete Code : 
```
class Solution {
    public int minDistance(String w1, String w2) {
        
        int n = w1.length(), m = w2.length();
        
        if(w1.equals(w2)) return 0;
        if(n == 0) return m; // delete chars
        if(m == 0) return n; // insert chars
        
        int[][]dp = new int[n+1][m+1];
        
        // initial states
        for(int i=0;i<n+1;i++) 
            dp[i][0] = i;
        
        for(int j=0;j<m+1;j++)
            dp[0][j] = j;
        
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<m+1;j++) {
                if(w1.charAt(i-1) != w2.charAt(j-1))
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                else dp[i][j] = dp[i-1][j-1];
            }
        }
        
        return dp[n][m];
    }
}
```

# Post Submission Thoughts : 
Can the solution be optimised ? 
YES, since the current dp state `dp[i][j]` depends only on the previous row, we can optimise the solution.
