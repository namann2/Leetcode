class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        StringBuilder ans = new StringBuilder();
        int n = word.length();
        for(int i = 0; i < n; i++) {
            ans.append(word.charAt(i));
            if(i == idx)
                ans.reverse();
        }
        return ans.toString();
    }
}