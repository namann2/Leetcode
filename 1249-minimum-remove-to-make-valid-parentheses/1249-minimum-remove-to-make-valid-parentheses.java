class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        StringBuilder ans = removeInvalid(s, '(' , ')');
        ans = removeInvalid(ans.reverse(), ')', '(');
        return ans.reverse().toString();
    }
    
    private StringBuilder removeInvalid(CharSequence s, char open_char, char close_char) {
        StringBuilder answer = new StringBuilder();
        int open = 0, close = 0, n = s.length();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch)) answer.append(ch);
            else if(ch == open_char) {
                open++;
                answer.append(ch);
            }
            else {
                if(open > close) {
                    open--; // found a pair
                    answer.append(ch);
                } else {
                    // we did not find a ( to pair with )
                }
            }
        }
        return answer;
    }
}