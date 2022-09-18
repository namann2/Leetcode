# Template Explanation :
https://leetcode.com/problems/cutting-ribbons/discuss/1654234/Java-Binary-Search-or-Similar-Questions
​
1. We need to work on input in a contiguous manner. i, i+1, i+2,...
2. We can update our search space ( in a sorted sequence )
​
​
`
Time complexity: O(n * logSIZE), where SIZE is the size of the search space (sum of weights - max weight).
Space complexity: O(1)
`
​
```
class Solution {
public int shipWithinDays(int[] w, int d) {
// The min capacity of the ship should be ? The maximum weight that we need to ship
// The max capacity of the ship should be ? If we ship all the weights in one day
int max = -1, sum=0;
for(int i=0;i<w.length;i++) {
sum += w[i];
max = Math.max(max, w[i]);
}
// we have now the range of elements
// why start = max ?
// bcz Cargo must to capable enough to take each weight individually
// and the max weight is 10, so cap should be >=10
int start = max, end = sum, ans=-1;
while(start<=end) {
int mid = start+(end-start)/2;
if(canShip(w, d, mid)) {
ans = mid;
end = mid-1;
}
else start = mid+1;
}
return ans;
}
private boolean canShip(int[]w, int d, int maxCap) {
int days = 1;
int currCap = 0;
for(int i=0;i<w.length;i++) {
currCap += w[i];
if(currCap > maxCap) {
currCap = w[i];
days++;
if(days > d) return false;
}