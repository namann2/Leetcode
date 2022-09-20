When we talk about Longest Common Substring : 
We have two options which can be used when either len or actual longest substring is asked
* Sliding Window : 
	* TC : `O(nm) * O(min(n,m))`, SC : `O(1)`
* DP : 
	* TC : `O(nm)`, SC : `O(nm)`

# Sliding Window Approach : 
https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/109059/O(mn)-time-O(1)-space-solution

Note : To find the actual substring, see the submitted code

```
class Solution {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int result = 0;
        for(int i=0;i<n+m-1;i++) {
            int fs = Math.max(0, A.length-1-i);
            int ss = Math.max(0, i-(A.length-1));
            int curr = 0;
            for(;fs<n && ss<m;fs++,ss++) {
                if(A[fs] == B[ss]) curr++;
                else curr = 0;
                result = Math.max(result, curr);
            }
        }
        return result;
    }
}
```
