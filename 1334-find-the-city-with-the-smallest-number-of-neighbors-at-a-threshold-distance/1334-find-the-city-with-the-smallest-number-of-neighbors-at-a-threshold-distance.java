class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        /*
            Question : 
            - Can from == to ?
                : Assume no
            
            Observations : 
            1. Given an undirected graph
            2. I need to reach every city from given cities and find out the min distance it requires to reach them. 
            3. Iterate again and find the distance which is less than the given threshold and store the corresponding city
            
            Note : We are given that the distances b/w cities will always be positive hence, we can use
                - Djikstra
                - Bellman Ford
                - Flyod Warshal
                
            I am going ahead with Floyd Warshal given that it is simple in implementation and could hold for the given constraints
        */
        
        int INF = (int)1e9 + 7;
        
        // constructs the graph
        int[][] matrix = new int[n][n];
        for(int[] edge : edges) {
            matrix[edge[0]][edge[1]] = matrix[edge[1]][edge[0]] = edge[2];
            matrix[edge[0]][edge[0]] = matrix[edge[1]][edge[1]] = 0;
        }
        
        
        for(int src = 0; src < n; src ++) {
            for(int dest = 0; dest < n; dest ++) {
                if(src != dest && matrix[src][dest] == 0) matrix[src][dest] = INF;
            }
        }
        
        for(int via = 0; via < n; via ++) {
            for(int src = 0; src < n; src ++) {
                for(int dest = 0; dest < n; dest++) {
                    matrix[src][dest] = Math.min(matrix[src][dest], matrix[src][via] + matrix[via][dest]);
                }
            }
        }

        int[] reachableCities = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(matrix[i][j] <= distanceThreshold) {
                    reachableCities[i]++;
                }
            }
        }
        
        // System.out.println(Arrays.toString(reachableCities));
        
        int ans = -1, smallestReachableCount = INF;
        for(int i = 0; i < n; i++) {
            // System.out.println(reachableCities[i]+" :: "+i);
            if(smallestReachableCount >= reachableCities[i]) {
                ans = i;
                smallestReachableCount = reachableCities[i];
            }
        }
        return ans;
    }
}