Check Complete notes :
```
class Solution {
public int[] maxSlidingWindow(int[] nums, int k) {
Deque<Integer> q = new ArrayDeque<>();
int n = nums.length, idx = 0;
int[] ans = new int[n-k+1];
// we maintain a monotonic queue
// we care about the max in a k range, but what if
// while moving the window ahead, the max element also vanishes in the prev window ?
// for this we need to store the max and second max and third....
// matter is : We need to store numbers smaller than the current max bcz
// they have the potential to become the max in next window.
int begin = 0, end = 0;
while(end < n) {
while(!q.isEmpty() && nums[end] > nums[q.peekLast()]) q.removeLast();
q.addLast(end);
if(end-begin+1 == k) {
ans[idx++] = nums[q.peekFirst()];
if(!q.isEmpty() && begin == q.peekFirst()) q.removeFirst();
begin++;
}
end++;
}
return ans;
}
}
```
​
​
<hr>
<br>
​
​
There are several problems similar to this :
​
https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
​
Maximum number of robots within budgets