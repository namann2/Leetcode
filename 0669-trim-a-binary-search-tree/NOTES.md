arr = [5 2 3 8 6 7]
arr = [8 3 8 8 7 7]
​
1. TC : O(n)
​
​
stack => 6 8 3 2 5
​
class Solution {
​
public int[] findNext(int[] A) {
if(A==null || A.length == 0)
return new int[]{};
int n = A.length;
int[]result = new int[n];
Stack<Integer> stack = new LinkedList<>(); // Deque<Integer> stack = new ArrayDeque<>();
//result[n-1] = A[n-1];
// stack.push(A[i]);
for(int i=n-1;i>=0;i--) {
while(!stack.isEmpty() && stack.peek() < A[i]) {
stack.pop();
}