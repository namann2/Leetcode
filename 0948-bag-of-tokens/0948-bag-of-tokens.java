class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // greedy approach
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
            }  // only increase power or i.e. decrease score only if we have the chance to increase 
            // score afterwards. Thus, left < right or left != right
            else if(score >= 1 && left < right) {
                power += tokens[right--];
                score--;
            } else break;
        }
        return score;
    }
}