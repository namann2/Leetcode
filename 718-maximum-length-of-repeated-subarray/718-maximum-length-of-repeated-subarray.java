class Solution {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int maxLength = 0;
        // List<Integer> seq = new ArrayList<>();
        
        for(int i=0;i<n+m-1;i++) {
            int fs = Math.max(0, n-1-i);
            int ss = Math.max(0, 1-(m-i));
            // List<Integer> temp = new ArrayList<>();
            int currLength = 0;
            for(;fs < n && ss < m; fs++, ss++) {
                if(A[fs] == B[ss]) {
                    currLength++;
                    // temp.add(A[fs]);
                }
                else currLength = 0;
                if(maxLength < currLength) {
                    // seq = temp;
                    maxLength = currLength;
                }
            }
        }
        // System.out.println(seq);
        return maxLength;
    }
}