class Solution {
    public String mergeAlternately(String A, String B) {
        StringBuilder ans = new StringBuilder();
        int n = A.length(), m = B.length();
        int i = 0, j = 0;
        while(i < n && j < m) {
            ans.append(A.charAt(i++));
            ans.append(B.charAt(j++));
        }
        while(i < n)
            ans.append(A.charAt(i++));
        while(j < m)
            ans.append(B.charAt(j++));
        
        return ans.toString();
    }
}