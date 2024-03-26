```
class CustomComparator implements Comparator<int[]> {
public int compare(int[] a, int[] b) {
int val = Integer.compare(a[0],b[0]);
// works in both the cases, remove this or not
// if(val==0) {
//     val = Integer.compare(a[1], b[1]); // if width is same, keep smallest height at front
// }
return val;
}
}
class Solution {
public int maxEnvelopes(int[][] envelopes) {
Arrays.sort(envelopes, new CustomComparator());
int n = envelopes.length;
// For every envelope, we have a question : How many envelopes can
// come inside the current envelope i.e.
// keeping the current envelope as the outer envelope, how many more envelopes
// can be placed inside this. ( Analogous to the definition of LIS )
int[]dp = new int[n];
int russianDoll = 1;
dp[0] = 1;
for(int i=1;i<n;i++) {
int max = 0;
for(int j=0;j<i;j++) {
if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
if(dp[j] > max) {
max = dp[j];
}
}
}
dp[i] = max + 1;
russianDoll = Math.max(russianDoll, dp[i]);
}
return russianDoll;
}
}
```