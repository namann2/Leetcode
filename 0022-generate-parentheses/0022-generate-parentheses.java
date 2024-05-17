class Solution {
    
    private static final char OP = '(';
    private static final char CP = ')';
    
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        generateParenthesis(n, n, new StringBuilder(), answer);
        return answer;
    }
    
    private void generateParenthesis(int open, int close, StringBuilder temp, List<String> answer) {
        // base case
        if(open == 0 && close == 0) {
            answer.add(temp.toString());
            return;
        }
        
        if(open == close) {
            temp.append(OP);
            generateParenthesis(open - 1, close, temp, answer);
            temp.deleteCharAt(temp.length() - 1);
        } else {
            if(open > 0) {
                temp.append(OP);
                generateParenthesis(open - 1, close, temp, answer);
                temp.deleteCharAt(temp.length() - 1);
            }
            if(close > 0) {
                temp.append(CP);
                generateParenthesis(open, close - 1, temp, answer);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}