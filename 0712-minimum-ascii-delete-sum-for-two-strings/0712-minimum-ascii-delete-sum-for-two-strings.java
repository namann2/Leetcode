class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int s1Length = s1.length(), s2Length = s2.length();

        // bottom up solution
        int[] prev = new int[s2Length + 1];

        for(int index2 = 1; index2 < s2Length + 1; index2++) {
            prev[index2] = s2.charAt(index2 - 1) + prev[index2 - 1];
        }

        // dp[index1][0] needs to be converted to curr[0], hence, update
        // the logic to where curr is being initialized
        // for(int index1 = 1; index1 < s1Length + 1; index1++) {
        //     dp[index1][0] = s1.charAt(index1 - 1) + dp[index1 - 1][0];
        // }

        // iteration
        for(int index1 = 1; index1 < s1Length + 1; index1 ++) {
            int[] curr = new int[s2Length + 1];
            curr[0] = s1.charAt(index1 - 1) + prev[0];
            for(int index2 = 1; index2 < s2Length + 1; index2 ++) {
                if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
                    curr[index2] = prev[index2 - 1];
                } else {
                    curr[index2] = Math.min(s1.charAt(index1 - 1) + prev[index2], s2.charAt(index2 - 1) + curr[index2 - 1]);
                }
            }
            prev = curr;
        }
        return prev[s2Length];
    }
}