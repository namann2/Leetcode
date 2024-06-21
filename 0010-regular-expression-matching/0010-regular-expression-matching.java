class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        return regexMatch(s, p, 0, 0, n, m);
    }
    
    private boolean regexMatch(String s, String p, int i, int j, int n, int m) {
        if(i == n && j == m) return true;
        
        if(j+1 < m && p.charAt(j+1) == '*') {
            boolean zeroMatch = regexMatch(s, p, i, j+2, n, m);
            if(zeroMatch) return true;
            // one or more match
            if(i < n && j < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) // consider ba with a* : in this case we need to return false
                if(regexMatch(s, p, i+1, j, n, m))
                    return true;
        } else {
            if(i < n && j < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                if(regexMatch(s, p, i+1, j+1, n, m))
                    return true;
            }
        }
        return false;
    }
}