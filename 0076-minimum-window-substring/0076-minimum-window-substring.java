class Solution {
    public String minWindow(String s, String t) {
        
        if(s.equals(t))
            return s;
        
        int n = s.length(), m = t.length();
        
        Map<Character, Integer> T = new HashMap<>();
        Map<Character, Integer> S = new HashMap<>();
        
        // update the frequency of each character
        for(int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            T.put(ch, T.getOrDefault(ch, 0) + 1);
        }
        
        int needed = m, matched = 0, start = 0, finish = 0;
        int begin = 0, end = 0;
        int minLength = Integer.MAX_VALUE;
        
        while(end < n) {
            char s_ch = s.charAt(end);
            S.put(s_ch, S.getOrDefault(s_ch, 0) + 1);
            if(T.containsKey(s_ch) && T.get(s_ch) >= S.get(s_ch)) matched++;
            while(matched == needed) {
                if(minLength > end - begin + 1) {
                    minLength = end - begin + 1;
                    start = begin;
                    finish = end;
                }
                
                char b_ch = s.charAt(begin);
                S.put(b_ch, S.get(b_ch) - 1);
                if(S.get(b_ch) == 0) S.remove(b_ch);
                if(T.containsKey(b_ch) && T.get(b_ch) > S.getOrDefault(b_ch, 0)) matched--;
                begin++;
            } 
            end++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, finish + 1);
    }
}