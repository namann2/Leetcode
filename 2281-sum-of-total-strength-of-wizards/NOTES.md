```
// find the strength of all the subarrays
// we can find the contribution of a particular number
// number of subarrays where A[i] is the min and what is the sum of those subarrays
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
// System.out.println(Arrays.toString(s));
// System.out.println(Arrays.toString(e));
// System.out.println(Arrays.toString(psps));
long ts = 0;
for(int i=0;i<n;i++) {
long x1 = psps[i+s[i]+1];
long x2 = psps[i+1];
long ex = e[i];
long y1 = psps[i-e[i]+1];
long sx = s[i];
long one = ((x1 - x2) * ex) % mod ;
long two = ((x2 - y1) * sx) % mod;
// System.out.println("one : "+one);
// System.out.println("two : "+two);
// System.out.println("x1 : "+x1);
// System.out.println("x2 : "+x2);
// System.out.println("ex : "+ex);
​