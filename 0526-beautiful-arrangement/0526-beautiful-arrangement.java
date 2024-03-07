class Solution {
    public int countArrangement(int n) {
        int[]A = new int[n];
        for(int i=0;i<n;i++)
            A[i] = i+1;
        return solve(A, new boolean[n], 0, n);
    }
    private int solve(int[] A, boolean[] used, int index, int n) {
        // base case
        if(index == n) {
            return 1;
        }
        // main logic
        int ans = 0;
        for(int i=1;i<n+1;i++) {
            if(!used[i-1] && ((A[index] % i == 0) || (i % A[index] == 0))) {
                used[i-1] = true;
                ans += solve(A, used, index+1, n);
                used[i-1] = false;
            }
        }
        return ans;
    }
}