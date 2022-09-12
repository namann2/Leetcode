```
- Brute Force : O(nk)
- O(n^2) using a PriorityQueue
- O(n) using a Deque
```

# PQ approach : 

```

// TC : O(n^2)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int end = 0, begin = 0, n = A.length;
        int []result = new int[n-k+1];
        int index = 0;
        while(end < n) {
            pq.add(A[end]);
            if(end-begin+1 == k) {
                result[index++] = pq.peek();
                pq.remove(A[begin]); // O(n)
                begin++;
            }
            end++;
        }
        return result;
				
```
We are trying to remove the not necessary elements from the PQ approach. We only care about the maximum elements and so, for a particular window if there is an element  which is smaller than the current window max we need not keep it inside the Deque

So, while adding an element if we have smaller elements in the deque then we will remove them as they won't contribute to the maximum in any window.

# Final Solution : Use Deque

```
class Solution {
    public int[] maxSlidingWindow(int[]A, int k) {
        // notes
        Deque<Integer> dq = new ArrayDeque<Integer>(k);
        int begin=0, end=0, i=0, n=A.length;
        int[] result = new int[n-k+1];
            
        while(end < n) {
            while(!dq.isEmpty() && dq.peekLast() < A[end]) dq.removeLast();
            dq.addLast(A[end]);
            if(end-begin+1 == k) {
                result[i++] = dq.peekFirst();
                if(!dq.isEmpty() && dq.peekFirst() == A[begin]) dq.removeFirst();
                begin++;
            }
            end++;
        }
        return result;
    }
}
```
