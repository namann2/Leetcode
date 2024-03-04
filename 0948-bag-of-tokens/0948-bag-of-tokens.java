class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        if(tokens == null || n == 0) return 0;
        Arrays.sort(tokens);
        if(power < tokens[0]) return 0;
        
        int score = 0;
        int left = 0, right = n-1;
        
        while(left <= right) {
            if(power >= tokens[left]) {
                power -= tokens[left++];
                score++;
            } else if(score >= 1 && left != right) {
                power += tokens[right--];
                score--;
            } else break;
        }
        return score;
    }
}