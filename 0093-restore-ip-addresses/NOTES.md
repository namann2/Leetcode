Time Complexity :
```
/*
​
Naive Solution : O(n4) - 4 nested loops
Backtracking Solution : 3^4
because we have choice to pick
2      5525511135
/   |    \
start+1 start+2 start+3
3 choice for each element.
So, 3^n but this n will break for chunks of 4. So, 3^4
*/
​
​
```
​
​
```
/*
Time complexity O(3^4)
Space complexity O(n) for path variable
*/
class Solution {