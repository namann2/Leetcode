Correct TC from Solution Premium tab :
​
Time complexity: O(N!)
​
Unlike the brute force approach, we will only place queens on squares that aren't under attack. For the first queen, we have N options. For the next queen, we won't attempt to place it in the same column as the first queen, and there must be at least one square attacked diagonally by the first queen as well. Thus, the maximum number of squares we can consider for the second queen is N−2. For the third queen, we won't attempt to place it in 2 columns already occupied by the first 2 queens, and there must be at least two squares attacked diagonally from the first 2 queens. Thus, the maximum number of squares we can consider for the third queen is N−4. This pattern continues, resulting in an approximate time complexity of N!.
​
While it costs O(N^2)to build each valid solution, the amount of valid solutions S(N) does not grow nearly as fast as N!N!, so O(N! + S(N) * N^2) = O(N!)O(N!+S(N)∗N^2)=O(N!)
​
****
​
```
class Solution {
boolean[] cols;
boolean[] ndiag;
boolean[] rdiag;
public List<List<String>> solveNQueens(int n) {