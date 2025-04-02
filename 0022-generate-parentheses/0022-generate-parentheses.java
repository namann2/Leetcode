class Solution {

    private static final char OPEN = '(', CLOSE = ')';

    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        generateParenthesis(n, n, new StringBuilder(), parenthesis);
        return parenthesis;
    }

    private void generateParenthesis(int open , int close, StringBuilder temp, List<String> parenthesis) {
        // base case
        if(open == 0 && close == 0) {
            parenthesis.add(String.valueOf(temp));
            return;
        }
        // main logic
        if(open == close) {
            temp.append(OPEN);
            generateParenthesis(open - 1, close, temp, parenthesis);
            temp.deleteCharAt(temp.length() - 1);
        } else {
            if(open > 0) {
                temp.append(OPEN);
                generateParenthesis(open - 1, close, temp, parenthesis);
                temp.deleteCharAt(temp.length() - 1);
            }

            if(close > 0) {
                temp.append(CLOSE);
                generateParenthesis(open, close - 1, temp, parenthesis);
                temp.deleteCharAt(temp.length() - 1);
            }
        }

    }
}