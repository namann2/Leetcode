class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n];
        
        // The maximum indegree is N - 1.
        
        for(int[] t : trust) {
            degree[t[0]-1]--;
            degree[t[1]-1]++;
        }
        
        for(int i = 0; i < n; i++) {
            if(degree[i] == n-1)
                return i+1;
        }
        return -1;
    }
}