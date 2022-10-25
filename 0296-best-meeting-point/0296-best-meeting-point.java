class Solution {
    public int minTotalDistance(int[][] g) {
        // This is an optimal approach
        // We have traversed over the matrix in sorted sequence. So that we need not s
        // sort the array again
        
        // TC : O(nm), SC : (nm)
        int n = g.length, m = g[0].length;
        List<Integer> rows = new ArrayList<>(), cols = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(g[i][j] == 1)
                    rows.add(i);
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(g[j][i] == 1)
                    cols.add(i);
            }
        }
        
        int sr = rows.size();
        int sc = cols.size();
        
        int px = ((sr&1)==1) ? rows.get(sr/2) : (rows.get(sr/2) + rows.get(sr/2-1))/2;
        int py = ((sc&1)==1) ? cols.get(sc/2) : (cols.get(sc/2) + cols.get(sc/2-1))/2;
        
        int dis = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(g[i][j] == 1) {
                    dis += Math.abs(px-i) + Math.abs(py-j);
                }
            }
        }
        return dis;
    }
}