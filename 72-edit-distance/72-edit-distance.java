class Solution {
    public int minDistance(String w1, String w2) {
        
        int n = w1.length(), m = w2.length();
        
        if(w1.equals(w2)) return 0;
        if(n == 0) return m; // delete chars
        if(m == 0) return n; // insert chars
        
        // This is space optimised solution. Check Notes for O(n^2) SC
        // TC : O(n*m) , SC : O(m)
        int[]prev = new int[m+1];
        
        for(int j=0;j<m+1;j++)
            prev[j] = j;
        
        for(int i=1;i<n+1;i++) {
            int[]curr = new int[m+1];
            curr[0] = i;
            for(int j=1;j<m+1;j++) {
                if(w1.charAt(i-1) != w2.charAt(j-1))
                    curr[j] = 1 + Math.min(prev[j], Math.min(curr[j-1], prev[j-1]));
                else curr[j] = prev[j-1];
            }
            prev = curr;
        }
        
        return prev[m];
    }
}