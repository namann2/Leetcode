class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int max = 0;
        for(int[] trip : trips) 
            max = Math.max(max, trip[2]);
        
        int[]line = new int[max+1];
        for(int[] trip : trips) {
            line[trip[1]]+=trip[0];
            line[trip[2]]-=trip[0];
        }
        
        int[]ps = new int[max+1];
        int maxCap = line[0];
        ps[0] = line[0];
        
        for(int i=1;i<max+1;i++) {
            ps[i] = ps[i-1] + line[i];
            maxCap = Math.max(maxCap, ps[i]);
        }
        
        return maxCap <= capacity;
    }
}

// 1 2 3 4 5 6 7
// 2 2 2 2 0 0 0
// 0 0 3 3 3 3 3
// 2 2 5 5 3 3 3 