class Solution {
    public int[] answerQueries(int[] A, int[] q) {
        int m = q.length;
        int[]answer = new int[m];
        // since subsequence, order does not matter
        Arrays.sort(A);
        int n = A.length;
        for(int i=1;i<n;i++)
            A[i] += A[i-1];
        
        for(int i=0;i<m;i++) {
            int idx = binarySearch(A, q[i]);
            if(idx != -1) 
                answer[i] = idx+1;
        }
        return answer;
    }
    private int binarySearch(int[]A, int sum) {
        int n = A.length;
        int start = 0, end = n-1, ans = -1;
        while(start <= end) {
            int m = start + (end - start)/2;
            if(A[m] <= sum) {
                ans = m;
                start = m + 1;
            } else end = m - 1;
        }
        return ans;
    }
}