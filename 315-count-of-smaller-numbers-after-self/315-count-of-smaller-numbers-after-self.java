class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        // TC : O(N log range) here, range = 2*10^4 i.e. fixed -> O(N)
        // SC : O(N) + O(N) - to build a segment tree + to reverse the collection -> O(N)
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        int n = nums.length;
        int delta = (int)Math.pow(10, 4)+1;
        for(int i=0;i<n;i++)
            nums[i] += delta;
        
        // max number can be 2*10^4
        Tree t = new Tree(2*delta);
        int size = 2*delta;
        for(int i=n-1;i>=0;i--) {
            int cnt = t.query(0, size-1, 0, nums[i]-1, 0);
            t.update(0, size-1, nums[i], 0);
            result.add(cnt);
        }
        Collections.reverse(result);
        return result;
    }
}

class Tree {
    int[]tree;
    Tree(int n) {
        tree = new int[4*n];
    }
    
    public int query(int L, int R, int left, int right, int st) {
        // complete overlap left..L..R...right
        if(L >= left && R <= right)
            return tree[st];
        
        // no overlap L..R left...right L..R
        if(left > R || right < L)
            return 0;
 
        int mid = L + (R-L)/2;
        int cnt1 = query(L, mid, left, right, 2*st+1);
        int cnt2 = query(mid+1, R, left, right, 2*st+2);
        
        return cnt1 + cnt2;
    }
    
    public void update(int L, int R, int val, int st) {
        if(L==R && L==val) {
            tree[st]++;
            return;
        }
        // this line is additional check
        if(L > R) return;
        
        int mid = L + (R -L)/2;
        
        if(val <= mid)
            update(L, mid, val, 2*st+1);
        else 
            update(mid+1, R, val, 2*st+2);
        
        tree[st] = tree[2*st+1] + tree[2*st+2];
    }
}