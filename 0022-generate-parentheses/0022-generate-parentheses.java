class Solution {

    private static final String OPEN = "(", CLOSE = ")";
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        generateParenthesis(n, n, new StringBuilder(), answer); // TODO : update the usage of string to stringbuilder
        return answer;
    }

    private void generateParenthesis(int open, int close, StringBuilder temp, List<String> answer) {
        if(open == 0 && close == 0) {
            answer.add(temp.toString());
            return;
        }
        if(open == close) {
            temp.append(OPEN);
            generateParenthesis(open - 1, close, temp, answer);
            temp.deleteCharAt(temp.length()-1);
        }
        else if(open < close) {
            if(open > 0) {
                temp.append(OPEN);
                generateParenthesis(open - 1, close, temp, answer);
                temp.deleteCharAt(temp.length()-1);
            }
            if(close > 0) {
                temp.append(CLOSE);
                generateParenthesis(open, close - 1, temp, answer);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}