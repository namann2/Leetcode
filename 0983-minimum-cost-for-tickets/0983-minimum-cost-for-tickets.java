class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer[] dp = new Integer[n+1];
        // return minCost(days, costs, 0, n, dp);
        
        int[] ahead = {1, 7, 30};
        for(int index = n - 1; index >= 0; index--) {
            int min = Integer.MAX_VALUE;
            for(int cost = 0; cost < 3; cost++) {
                int nextDayToBuyTicket = days[index] + ahead[cost];
                int nextIndex = index;
                for(int day = index; day < n; day++) {
                    if(days[day] >= nextDayToBuyTicket) break;
                    nextIndex++;
                }
                int currCost = costs[cost] + (dp[nextIndex] == null ? 0 : dp[nextIndex]);
                min = Math.min(min, currCost);
            }    
            dp[index] = min;
        }
        return dp[0];
    }
}