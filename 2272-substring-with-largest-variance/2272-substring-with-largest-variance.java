class Solution {
    public int largestVariance(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        int variance1 = findMaxVariance(s);
        int variance2 = findMaxVariance(new StringBuilder(s).reverse().toString());
        
        return Math.max(variance1, variance2);
    }
    private int findMaxVariance(String s) {
        int n = s.length();
        int maxi = 0;

        for(char first = 'a';first <= 'z'; first++) {
            for(char second = 'a'; second <= 'z'; second++) {
                if(first == second) continue;
                int cntA = 0, cntB = 0;
                for(int i = 0; i< n; i++) {
                    char ch = s.charAt(i);
                    if(ch == first) cntA++;
                    if(ch == second) cntB++;
                    if(cntA > 0 && cntB > 0) maxi = Math.max(maxi, cntA - cntB);
                    if(cntB > cntA) cntA = cntB = 0;
                }
            }
        }
        return maxi;
    }
}