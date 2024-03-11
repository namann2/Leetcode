for(int day = index; day < n; day++) {
if(days[day] >= nextDayToBuyTicket) break;
nextIndex++;
}
int currCost = costs[cost] + minCost(days, costs, nextIndex, n);
min = Math.min(min, currCost);
}
return min;
}
}
```
​
## Top - Down DP
​
TC : O(n^2)
SC : O(n)
​
```
class Solution {
public int mincostTickets(int[] days, int[] costs) {
int n = days.length;
Integer[] dp = new Integer[n];
return minCost(days, costs, 0, n, dp);
}
private int minCost(int[] days, int[] costs, int index, int n, Integer[] dp) {
// base case
if(index >= n) return 0;
if(dp[index] != null)
return dp[index];
// main logic
int[] ahead = {1, 7, 30};
int min = Integer.MAX_VALUE;
for(int cost = 0; cost < 3; cost++) {
int nextDayToBuyTicket = days[index] + ahead[cost];
int nextIndex = index;
for(int day = index; day < n; day++) {
if(days[day] >= nextDayToBuyTicket) break;
nextIndex++;
}
int currCost = costs[cost] + minCost(days, costs, nextIndex, n, dp);
min = Math.min(min, currCost);
}
return dp[index] = min;
}
}
```