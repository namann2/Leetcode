class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length(), m = t.length();
        if(n != m) return false;
        
        int[] index1 = new int[256];
        int[] index2 = new int[256];
        
        
        // bde - cce
        for(int i = 0; i < n ; i++) {
            char s_ch = s.charAt(i), t_ch = t.charAt(i);
            if(index1[s_ch] != index2[t_ch]) return false;
            index1[s_ch] = index2[t_ch] = i+1;
        }
        return true;
    }
}