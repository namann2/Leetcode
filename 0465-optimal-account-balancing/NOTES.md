What is the time complexity of this solution? In my opinion, assume curId in each recursion level are i, k, k, m etc.
1st level ,say i, i starts from 0 -> n - 1 in for loop.
2nd level ,say j, j starts from i + 1 -> n - 1
...
n - 3 th level ,say k, k starts from n - 2 -> n - 1
n - 2 th level, say m, m starts from n - 1 -> n - 1.
So time complexity is O(n!) where n is length of transactions
​
```
class Solution {
public int minTransfers(int[][] transactions) {
int n = transactions.length;
HashMap<Integer, Integer> map = new HashMap<>();
for(int[] trans : transactions) {
map.put(trans[0], map.getOrDefault(trans[0], 0)-trans[2]);
map.put(trans[1], map.getOrDefault(trans[1], 0)+trans[2]);
}
int[] A = new int[map.size()];
int idx = 0;
for(int key : map.keySet())
A[idx++] = map.get(key);
return settle(A, 0, map.size());
}
private int settle(int[]A, int index, int n) {
// base case
if(index == n)
return 0;
if(A[index] == 0)
return settle(A, index+1, n);
// main logic
// O(n!)
int min = Integer.MAX_VALUE;
for(int i=index+1;i<n;i++) {
if(A[index] * A[i] >= 0) continue;
A[i] += A[index];
min = Math.min(min, 1+settle(A, index+1, n));
A[i] -= A[index];
}
return min;
}
}
​
​
```