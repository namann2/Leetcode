# Solution 1 : Using BFS

```

class Solution {
    public boolean canReach(int[] A, int start) {
        if(A[start] == 0)
            return true;
        int n = A.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        HashSet<Integer> vis = new HashSet<>();
        vis.add(start);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(A[curr] == 0) return true;
            
            int fwd = curr + A[curr];
            int bck = curr - A[curr];
            
            if(fwd < n && vis.add(fwd)) q.add(fwd);
            if(bck >= 0 && vis.add(bck)) q.add(bck);
        }
        return false;
    }
}


```


******


# Solution 2 : DFS


```
class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr == null) return false;
        if(arr.length == 1) return arr[0] == 0;
        return canReach(arr, start, arr.length);
    }
    private boolean canReach(int[] A, int start, int n) {
        
        if(start >= n || start < 0) return false;
        
        if(A[start] == 0) return true;
        
        int forward = start + A[start];
        int backward = start - A[start];
        // changing the value of current index so that we do not come back to this and start iterating
        // forawsd and backward again. If this index was to give an answer it would be handled in the base case
        // and would not have reached to this point
        A[start] = n;
        
        if(forward < n) {
            if(canReach(A, forward, n)) return true;
        }
        if(backward >= 0) {
            if(canReach(A, backward, n)) return true;
        }
        return false;
    }
}
```
