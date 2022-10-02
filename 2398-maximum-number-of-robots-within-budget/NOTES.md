# Binary Search Solution : O(n * logn * logn)
```
class Solution {
public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
int n = chargeTimes.length;
int start = 1, end = n;
int ans = 0;
SegmentTree tree = new SegmentTree(n, chargeTimes);
while(start <= end) {
int mid = start + (end - start) / 2;
if(canTake(tree, mid, runningCosts, budget)) {
ans = mid;
start = mid + 1;
} else end = mid - 1;
}
return ans;
}
private boolean canTake(SegmentTree tree, int k, int[] runningCosts, long budget) {
int begin = 0, end = 0, n = runningCosts.length;
long sum = 0;
while(end < n) {
sum += runningCosts[end];
if(end-begin+1 == k) {
long currbudget = sum * k + tree.query(begin, end);
if(currbudget <= budget) return true;
// no overlap L...R left...right L...R