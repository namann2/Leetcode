class Solution {
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        int n = num.length();
        for(int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            count[ch-'0']++;
        }
        
        StringBuilder answer = new StringBuilder();
        int largestOddNumber = -1;
        for(int i = 9; i >= 0; i--) {
            // avoid considering 0's for begining of answer
            if(i == 0 && answer.length() == 0) continue;
            if(count[i] % 2 == 1 && largestOddNumber == -1)
                largestOddNumber = i;
            for(int k = 0; k < count[i]/2; k++)
                answer.append(i);
        }
        
        // input : 0's ( 0, 00, 000 etc )
        if(answer.length() == 0 && largestOddNumber == -1) return "0";
        
        StringBuilder half = new StringBuilder(answer);

        if(largestOddNumber != -1) {
            answer.append(largestOddNumber);
        }
        
        answer.append(half.reverse()); 
        
        return answer.toString();
    }
}