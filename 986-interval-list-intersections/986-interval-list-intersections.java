class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        /*
            Two cases : 
            1. Non overlapping
            2. overlapping
                a. A overlaps B
                b. B overlaps A
                overlapping - [max of start, min of end]
        */
        if(A==null || B==null) return null;
        int i=0,j=0;
        ArrayList<int[]> ans = new ArrayList<>();
        int n = A.length, m = B.length;
        while(i<n && j<m) {
            // check if there is an overlap
            int[] Ai = A[i];
            int[] Bj = B[j];
            // if intervals overlap
            int start = Math.max(Ai[0], Bj[0]);
            int end = Math.min(Ai[1], Bj[1]);
            
            if(end >= start) ans.add(new int[]{start, end});
            
            if(Ai[1]==end) i++;
            if(Bj[1]==end) j++;
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}
