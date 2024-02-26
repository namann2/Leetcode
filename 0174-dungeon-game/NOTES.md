# Thought Process :

If we need to find the minimum health the knight needs to have, then
it should be equal to the path which will cost him min loss in health.
Or in other words, that path which requires min positive health to begin with.

Since we asked the minimum health, we should be thinking in two terms :
1. Binary Search - `BS on answer` can be applied but the canReach functionality won't be optimal since we will have to traverse the matrix again ana again which can be optimally solved using DP
2. DFS/BFS - more intuitive if we were given that all 4 directions were reachable. [ in such case, dp is questionable ]
3. DP

Since we are restricted with two directions, we can optimally use DP to calculate the result.
If we would have been asked that the knight can go in 4 directions, dp would have been
tough (probably questionable) and we would have to use BFS/DFS

Now that we know that DP is the optimal solution, We will try to find/define the dp state.
If we are not able to define dp state directly, we will think in terms of recursion and then
find/define the same.

There are 2 changing variables row and col.

dp[i][j] = min health required to reach the final cell (n-1, m-1) from a cell (i,j)
