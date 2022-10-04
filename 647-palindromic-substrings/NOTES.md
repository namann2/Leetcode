* col
We are moving in a digonal fashion in the grid.
3. After making deductions, write code :
​
```
class Solution {
public int countSubstrings(String s) {
// Check Notes'
if(s==null || s.length()==0) return 0;
if(s.length() == 1) return 1;
boolean[][] dp = new boolean[s.length()][s.length()];
int ans = 0;
for(int g=0;g<s.length();g++) {
// for every gap, our "row" starts from 0
int row = 0;
for(int col = g;col<s.length();col++) {
if(g==0) {
dp[row][col] = true;
}
else if(g==1) {
dp[row][col] = s.charAt(row) == s.charAt(col);
}
else {
dp[row][col] = s.charAt(row) == s.charAt(col) && dp[row+1][col-1];
}
ans += dp[row][col] == true ? 1 : 0;
row++; // update row and col for next diagonal cell
}
}
return ans;
}
}
```