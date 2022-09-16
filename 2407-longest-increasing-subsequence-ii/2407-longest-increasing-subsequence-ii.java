class Solution {
    public int lengthOfLIS(int[] A, int k) {
        int n = A.length;
        // for each number, count the answer for A[i] - x, where x = 0....k
        int max = 0;
        int size = Arrays.stream(A).max().getAsInt()+1;
        Tree t = new Tree(A, size);
        // nlogn
        for(int i=0;i<n;i++) {
            int left = Math.max(0, A[i] - k);
            int right = A[i] - 1;
            // LIS ending at A[i] = 1 + find the length of max subsequence in the range of left ... right
            int curr = 1 + t.query(left, right, 0, size-1, 0);
            max = Math.max(max, curr);
            t.update(0, size-1, A[i], curr, 0);
        }
        return max;
    }
}

class Tree {
    int n;
    int[]tree;
    Tree(int A[], int s) {
        n = A.length;
        tree = new int[4*s];
    }
    
    public int query(int left, int right, int L, int R, int st) {
        // no overlap L..R left...right L..R
        if(left > R || right < L) return 0;
        // complete overlap left..L...R.....right
        if(left<=L && right>=R)
            return tree[st];
        
        int mid = L + (R - L)/2;
        int a = query(left, right, L, mid, 2*st+1);
        int b = query(left, right, mid+1, R, 2*st+2);
        return Math.max(a, b);
    }
    
    public void update(int L, int R, int index, int val, int st) {
        if(L==R) {
            tree[st] = val;
            return;
        }
        int mid = L + (R - L)/2;
        if(index <= mid)
            update(L, mid, index, val, 2*st+1);
        else 
            update(mid+1, R, index, val, 2*st+2);
        tree[st] = Math.max(tree[2*st+1], tree[2*st+2]);
    }
}