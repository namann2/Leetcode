class Solution {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int[] next = new int[n+1];
        int maxLength = 0;
        for(int i=n-1;i>=0;i--) {
            int curr[] = new int[n+1];
            for(int j=n-1;j>=0;j--) {
                if(s.charAt(i) == s.charAt(j) && i != j)
                    curr[j] = 1 + next[j+1];
                maxLength = Math.max(maxLength, curr[j]);
            }
            next = curr;
        }
        return maxLength;
    }
}