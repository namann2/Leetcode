class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        /*
            Observations : 
            1. All nodes are connected
            2. minimum streets required to reach one house from the other is k
            These observation point us to find out min distance between every house.
            This is a clear indication of all nodes shortest path i.e Floyd Warshal Algorithm
            TC : O(n^3)
            SC : O(n^2)
        */
        int[][]matrix = new int[n+1][n+1];
        for(int[] m : matrix)
            Arrays.fill(m, 101); // this shows there is no edge between two nodes
        
        // adjacent edges
        for(int i=1;i<n;i++) {
            matrix[i][i+1] = 1;
            matrix[i+1][i] = 1;
        }
        
        // update extra edge between x and y
        matrix[x][y] = matrix[x][y] == 101 ? 1 : matrix[x][y] ++;
        matrix[y][x] = matrix[y][x] == 101 ? 1 : matrix[y][x] ++;
        
        // update min distance from every node to every node
        for(int k = 1; k <= n; k++) { // via every vertex
            // for every edge, check if we can reach by what min distance
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
        int[] ans = new int[n];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) { // j!=i because min distance(k) we need to look is 1    
                if(i != j) {
                    int min_distance = matrix[i][j];
                    ans[min_distance-1]++;
                }
            }
        }
        return ans;
    }
}