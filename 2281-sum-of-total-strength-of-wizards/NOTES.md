Helpful for the condition : https://leetcode.com/problems/sum-of-total-strength-of-wizards/discuss/2062017/C%2B%2B-prefix-%2B-monotonic-stack-O(N)-solution-with-thought-process
​
​
# Thought Process :
We need to get the contribution of A[i] as the minimum element in the subarray.
We can get the number of arrays where A[i] is the minimum ( can be solved using monotonic stack )
The only dead-end is to find the summation of the subarrays where A[i] is the minimum element.
​
```
​
class Solution {
public int totalStrength(int[] strength) {
int n = strength.length;
int mod = (int)1e9+7;
int[]s = new int[n];
int[]e = new int[n];
startingAt(strength, s);
endingAt(strength, e);
long[] ps = new long[n+1];
for(int i=1;i<n+1;i++) ps[i] = strength[i-1] % mod + ps[i-1] % mod;
long[]psps = new long[n+2];
for(int i=1;i<n+2;i++) psps[i] = (ps[i-1] % mod + psps[i-1] % mod) % mod;
// System.out.println(Arrays.toString(strength));
int mod = (int)1e9+7;