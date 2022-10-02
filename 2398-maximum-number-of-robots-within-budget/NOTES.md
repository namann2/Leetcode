# Binary Search Solution : O(n * logn * logn)
```
class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int start = 1, end = n;
        int ans = 0;
        
        SegmentTree tree = new SegmentTree(n, chargeTimes);
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(canTake(tree, mid, runningCosts, budget)) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }
    
    private boolean canTake(SegmentTree tree, int k, int[] runningCosts, long budget) {
        int begin = 0, end = 0, n = runningCosts.length;
        long sum = 0;
        while(end < n) {
            sum += runningCosts[end];
            if(end-begin+1 == k) {
                long currbudget = sum * k + tree.query(begin, end);
                if(currbudget <= budget) return true;
                sum -= runningCosts[begin];
                begin++;
            }
            end++;
        }
        return false;
    }
}

class SegmentTree {
    int[] tree;
    int n;
    SegmentTree(int n, int[] A) {
        this.tree = new int[4*n];
        this.n = n;
        buildTree(0, n-1, A, 0);
    }
    public void buildTree(int L, int R, int[] A, int st) {
        if(L == R) {
            tree[st] = A[L];
            return;
        }
        int mid = L + (R - L)/2;
        buildTree(L, mid, A, 2*st+1);
        buildTree(mid+1, R, A, 2*st+2);
        tree[st] = Math.max(tree[2*st+1], tree[2*st+2]);
    }
    public int query(int left, int right) {
        return this.query(left, right, 0, n-1, 0);
    }
    private int query(int left, int right, int L, int R, int st) {
        // complete overlap left. .L..R....right
        if(L >= left && R <= right) return tree[st];
        // no overlap L...R left...right L...R
        if(left > R || right < L) return 0;
        
        int mid = L + (R - L)/2;
        return Math.max(query(left, right, L, mid, 2*st+1), 
                        query(left, right, mid+1, R, 2*st+2));
    }
}
```
