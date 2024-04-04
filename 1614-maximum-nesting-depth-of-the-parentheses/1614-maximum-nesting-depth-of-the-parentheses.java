class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int cnt = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') cnt++;
            else if(ch == ')') cnt--;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}