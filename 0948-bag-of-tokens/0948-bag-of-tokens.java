class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0, n = tokens.length, maxScore = 0;
        int left = 0, right = n-1;
        Arrays.sort(tokens);
        while(left <= right) {
            if(power >= tokens[left]) {
                power -= tokens[left++];
                maxScore = Math.max(maxScore, ++score);
            } else if(score >= 1) {
                score--;
                power += tokens[right--];
            } else break;
        }
        return maxScore;
    }
}