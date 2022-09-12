```
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0,j=0;
        ArrayList<int[]> result = new ArrayList<>();
        int n = A.length, m = B.length;
        while(i<n && j<m) {
            // check if there is an overlap
            int[] Ai = A[i];
            int[] Bj = B[j];
            // if overlap
            int start = Math.max(Ai[0], Bj[0]);
            int end = Math.min(Ai[1], Bj[1]);
            
            if(end >= start) result.add(new int[]{start, end});
            
            if(Ai[1]==end) i++;
            if(Bj[1]==end) j++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}
```
