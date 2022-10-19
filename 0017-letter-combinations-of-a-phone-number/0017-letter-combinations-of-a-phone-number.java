class Solution {
    static final String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if(digits == null || digits.length() == 0) 
            return answer;
        generateCombinations(digits, 0, digits.length(), new StringBuilder(), answer);
        return answer;
    }
    private void generateCombinations(String digits, int index, int n, StringBuilder op, List<String> answer) {
        // base case
        if(index == n) {
            answer.add(op.toString());
            return;
        }
        // main logic
        int ch = digits.charAt(index) - '0'; // 23
        String curr = strs[ch]; // abc, def
        for(char c : curr.toCharArray()) {
            op.append(c);
            generateCombinations(digits, index+1, n, op, answer);
            op.deleteCharAt(op.length()-1);
        }
    }
}