class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0, maxScore = 0;
        Arrays.sort(tokens);
        int n = tokens.length, left = 0, right = n-1;
        while(left <= right) {
            if(power >= tokens[left]) {
                score++;
                maxScore = Math.max(maxScore, score);
                power -= tokens[left++];
            } else if(score >= 1) {
                power += tokens[right--];
                score--;
            } else break;
        }
        
        return maxScore;
    }
}