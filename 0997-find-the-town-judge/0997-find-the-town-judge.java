class Solution {
    public int findJudge(int n, int[][] trust) {
        // see notes
        int[]trust_count = new int[n+1];
        
        for(int[] t : trust) {
            trust_count[t[1]]++;
            trust_count[t[0]]--;
        }
        
        // find the candidate
        for(int i=1;i<n+1;i++) {
            if(trust_count[i] == n-1) 
                return i;
        }
        return -1;
    }
}