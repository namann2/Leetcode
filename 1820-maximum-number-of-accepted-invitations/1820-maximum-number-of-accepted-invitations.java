class Solution {
    public int maximumInvitations(int[][] grid) {
        // boys = m, girls = n
        // TC : O(m * n * m) = O(n * m^2)
        // SC : O(n)
        int boys = grid.length, girls = grid[0].length;
        Map<Integer, Integer> match = new HashMap<>();
        for(int boy = 0; boy < boys; boy++) {
            dfs(grid, boy, boys, girls, new boolean[girls], match);
        }
        return match.size();
    }
    
    private boolean dfs(int[][] grid, int boy, int boys, int girls, boolean[] invited, Map<Integer, Integer> match) {
        // main logic
        for(int girl = 0; girl < girls; girl++) {
            // if boy can invite the girl and if the boy has not already invited her already
            if(grid[boy][girl] == 1 && !invited[girl]) {
                // invite
                invited[girl] = true;
                // check for a match now
                // 1. if the girl has not been matched earlier
                // 2. if the match is there, but the matched boy can go out with other girl
                if(!match.containsKey(girl) || dfs(grid, match.get(girl), boys, girls, invited, match)) {
                    match.put(girl, boy);
                    return true;
                }
            }
        }
        return false;
    }
}