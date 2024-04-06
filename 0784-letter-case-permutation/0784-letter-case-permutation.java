class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList<>();
        permute(s, 0, s.length(), new StringBuilder(), answer);
        return answer;
    }
    private void permute(String s, int index, int n, StringBuilder temp, List<String> answer) {
        // base case
        if(index == n) {
            answer.add(new String(temp));
            return;
        }
        
        char ch = s.charAt(index);
        boolean isLetter = Character.isLetter(ch);
        
        if(isLetter) {
            temp.append(Character.toLowerCase(ch));
            permute(s, index+1, n, temp, answer);
            temp.deleteCharAt(temp.length()-1);
            
            temp.append(Character.toUpperCase(ch));
            permute(s, index+1, n, temp, answer);
            temp.deleteCharAt(temp.length()-1);
        } else {
            temp.append(ch);
            permute(s, index+1, n, temp, answer);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}