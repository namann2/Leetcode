class Solution {
    public int minimumDeleteSum(String A, String B) {
        int n = A.length(), m = B.length();
        int[] next = new int[m+1];
        for(int i=n-1;i>=0;i--) {
            int[] curr = new int[m+1];
            for(int j=m-1;j>=0;j--) {
                if(A.charAt(i) == B.charAt(j)) 
                    curr[j] = A.charAt(i) + next[j+1];
                else
                    curr[j] = Math.max(next[j], curr[j+1]);
            }
            next = curr;
        }
        
        int lcs = next[0];
        int s1 = 0, s2 = 0;
        for(char ch : A.toCharArray()) s1 += ch;
        for(char ch : B.toCharArray()) s2 += ch;
        
        return s1 + s2 - 2*lcs;
    }
}