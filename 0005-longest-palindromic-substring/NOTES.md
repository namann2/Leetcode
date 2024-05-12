way 1 : pepcoding
```
class Solution {
public String longestPalindrome(String s) {
int n = s.length();
boolean[][]dp = new boolean[n][n];
int start = 0, end = 0;
​
for(int g=0;g<n;g++) {
int row = 0;
for(int col=g;col<n;col++) {
if(g == 0) {
dp[row][col] = true;
} else if(g==1) {
dp[row][col] = s.charAt(row) == s.charAt(col);
} else {
dp[row][col] = s.charAt(row) == s.charAt(col) && dp[row+1][col-1] == true;
}
if(dp[row][col]) {
// gap is always increasing thus, we can directly update our indices
start = row;
end = col;
}
row++;
}
}