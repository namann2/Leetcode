class Solution {
    public int minimumMoves(int[][] grid) {
        List<int[]> extras = new ArrayList<>();
        List<int[]> needs = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(grid[i][j] == 1) continue;
                if(grid[i][j] == 0) needs.add(new int[]{i, j});
                else if(grid[i][j] > 1) extras.add(new int[]{i, j});
            }
        }
        
        return minimumMoves(0, grid, extras, needs);
    }
    private int minimumMoves(int index, int[][]grid, List<int[]> extras, List<int[]> needs) {
        // base case
        if(index == needs.size())
            return 0;
        
        // main case
        int moves = (int)1e6;
        int zx = needs.get(index)[0];
        int zy = needs.get(index)[1];
        
        for(int j = 0; j < extras.size(); j++) {
            int ex = extras.get(j)[0];
            int ey = extras.get(j)[1];
            if(grid[ex][ey] == 1) continue;
            grid[ex][ey]--;
            grid[zx][zy] = 1;
            int currMove = Math.abs(zx - ex) + Math.abs(zy - ey);
            moves = Math.min(moves, currMove + minimumMoves(index + 1, grid, extras, needs));
            grid[ex][ey]++;
            grid[zx][zy] = 0;
        }
        return moves;
    }
}