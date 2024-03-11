class Solution {
    public String customSortString(String order, String s) {
        // TC : O(n + m), SC : O(26)
        int[]count = new int[26];
        for(char ch : s.toCharArray())
            count[ch-'a']++;
        
        StringBuilder answer = new StringBuilder();
        for(char ch : order.toCharArray()) {
            int cnt = count[ch-'a'];
            while(cnt-- > 0) answer.append(ch);
            count[ch - 'a'] = 0;
        }
        
        for(int i = 0; i < 26; i++) {
            char ch = (char)(i + 'a');
            while(count[i]-- > 0) answer.append(ch);
        }
        
        return answer.toString();
    }
}