class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        StringBuilder res = new StringBuilder("1");
        
        for(int i=1;i<n;i++) {
            res = createSequence(res);
        }
        
        return res.toString();
    }
    private StringBuilder createSequence(StringBuilder s) {
        int ptr = 0;
        StringBuilder t = new StringBuilder();
        while(ptr < s.length()) {
            char ch = s.charAt(ptr);
            int cnt = 1;
            // 11
            while(ptr+1 < s.length() && ch == s.charAt(ptr+1)) {
                ptr++;
                cnt++;
            }
            t.append(cnt).append(ch);
            ptr++;
        }
        return t;
    }
}