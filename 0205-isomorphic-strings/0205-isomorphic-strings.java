class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length(), m = t.length();
        if(n != m) return false;
        
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        for(int i = 0; i < n ; i++) {
            char s_ch = s.charAt(i), t_ch = t.charAt(i);
            if(map.containsKey(s_ch) && map.get(s_ch) != t_ch) return false;
            if(used.contains(t_ch) && !map.containsKey(s_ch)) return false;
            used.add(t_ch);
            map.put(s_ch, t_ch);
        }
        return true;
    }
}