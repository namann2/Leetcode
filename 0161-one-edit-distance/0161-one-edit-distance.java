class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n = s.length(), m = t.length();
        if(s.equals(t))
            return false;
        int i = n-1, j = m-1;
        while(i >= 0 && j >= 0) {
            if(s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                boolean delete = s.substring(0, i).equals(t.substring(0, j+1));
                boolean insert = s.substring(0, i+1).equals(t.substring(0, j));
                boolean replace = s.substring(0, i).equals(t.substring(0, j));
                return delete || insert || replace;
            }
        }
        return i <= 0; // in case when t is of smaller length, ith index should not be at 1,or 2 or any greater value since we have only one edit distance
    }
}
