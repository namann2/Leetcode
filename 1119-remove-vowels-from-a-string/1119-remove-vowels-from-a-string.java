class Solution {
    public String removeVowels(String s) {
        StringBuilder answer = new StringBuilder();
        String vowel = "aeiou";
        for(char ch : s.toCharArray()) {
            if(!isVowel(ch))
                answer.append(ch);
        }
        return answer.toString();
    }
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}