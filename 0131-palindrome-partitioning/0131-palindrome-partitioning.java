class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        palindrome_partition(s, s.length(), new ArrayList<>(), answer);
        return answer;
    }
    private void palindrome_partition(String s, int n, List<String> temp, List<List<String>> answer) {
        // base case
        if(n == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        // main logic
        for(int i=1;i<n+1;i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if(isPalindrome(prefix)) {
                temp.add(prefix);
                palindrome_partition(suffix, suffix.length(), temp, answer);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i <= j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}