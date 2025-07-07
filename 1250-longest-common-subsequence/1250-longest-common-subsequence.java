class Solution {
    public int longestCommonSubsequence(String word1, String word2) {
        int w1Length = word1.length(), w2Length = word2.length();
        // bottom up solution
        int[][] dp = new int[w1Length + 1][w2Length + 1];
        int[] prev = new int[w2Length + 1];
        for(int index1 = 1; index1 < w1Length + 1; index1++) {
            int[] curr = new int[w2Length + 1];
            for(int index2 = 1; index2 < w2Length + 1; index2++) {
                if(word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
                    curr[index2] = 1 + prev[index2 - 1];
                } else {
                    curr[index2] = Math.max(prev[index2], curr[index2 - 1]);
                }
            }
            prev = curr;
        }
        return prev[w2Length];
    }
}