class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> answer = new ArrayList<>();
        wordBreakUtil(s, wordSet, 0, s.length(), new ArrayList<>(), answer);
        return answer;
    }
    private void wordBreakUtil(String s, Set<String> wordSet, int index, int n, List<String> temp, List<String> answer) {
        // base case
        if(s.length() == 0) {
            answer.add(String.join(" ", temp));
            return;
        }
        // main logic
        for(int i = index; i < n+1; i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i, n);
            if(wordSet.contains(prefix)) {
                temp.add(prefix);
                wordBreakUtil(suffix, wordSet, 0, suffix.length(), temp, answer);
                temp.remove(temp.size()-1);
            }
        }
    }
}