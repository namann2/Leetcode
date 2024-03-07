class Solution {
    public int uniqueLetterString(String s) {
        int ans = 0;
        int[] seen = new int[26];
        Arrays.fill(seen, -1);
        int n = s.length();
        // since we need to find "strictly unique contributions", we
        // need to know till which index, the current char being the part
        // of a substring, will contribute to.
        
        // This problem is different than LC 2262, in this way that in prior problem,
        // distinct chars are counted but here, if the char is not distinct ie. have a duplicate, it is
        // not considered for contribution.
        int[] L = new int[n];
        for(int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'A';
            L[i] = seen[ch] == -1 ? i + 1 : i - seen[ch];
            seen[ch] = i;
        }
        
        Arrays.fill(seen, -1);
        
        int[] R = new int[n];
        for(int i = n-1; i >= 0; i--) {
            int ch = s.charAt(i) - 'A';
            R[i] = seen[ch] == -1 ? n - i : seen[ch] - i;
            seen[ch] = i;
        }
        for(int i=0;i<n;i++)
            ans += L[i] * R[i];
        
        return ans;
    }
}