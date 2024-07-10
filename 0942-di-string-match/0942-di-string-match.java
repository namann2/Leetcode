class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] answer = new int[n+1];
        int high = n, low = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == 'I') 
                answer[i] = low++;
            else answer[i] = high--;
        }
        
        answer[n] = s.charAt(n-1) == 'I' ? low : high;
        return answer;
    }
}