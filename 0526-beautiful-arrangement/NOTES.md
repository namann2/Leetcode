# Motivation :
```
https://leetcode.com/problems/beautiful-arrangement/discuss/99711/Java-6ms-beats-98-back-tracking-(swap)-starting-from-the-back
```
​
The first line makes sense to me. It makes sense to modify the permute function.
​
​
# Code :
​
TC : O(n!) is a weaker bound because we won't be generating all the permutations.
Let's say, out of n! permutation there are only "k" permutations that are valid, thus.
TC : O(k), SC : O(n)
```
class Solution {
int count;
// Check Notes
public int countArrangement(int n) {
if(n<=3) return n;
count = 0;
permute(n, n, new int[n+1]);