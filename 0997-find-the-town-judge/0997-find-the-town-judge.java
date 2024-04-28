class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        
        for(int[] t : trust) {
            outdegree[t[0]-1]++;
            indegree[t[1]-1]++;
        }
        
        for(int i = 0; i < n; i++) {
            if(indegree[i] == n-1 && outdegree[i] == 0)
                return i+1;
        }
        return -1;
    }
}