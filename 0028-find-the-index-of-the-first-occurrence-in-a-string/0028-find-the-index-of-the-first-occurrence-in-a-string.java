class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if(m > n) return -1;
        for(int i = 0; i <= n-m; i++) {
            int j = 0, k = i;
            while(j < m && needle.charAt(j) == haystack.charAt(k)) {
                j++;
                k++;
            }
            if(j == m) return i;
        }
        return -1;
    }
}