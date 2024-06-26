class Solution {
    public String convert(String s, int numRows) {
        int length = s.length();
        if(numRows == 1)
            return s;
        
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < numRows; i++) {
            int idx = i;
            int goingDown = 2 * (numRows - 1 - i);
            int goingUp = 2 * i;
            boolean down = true;
            while(idx < length) {
                answer.append(s.charAt(idx));
                if(i == 0) {
                    idx = idx + goingDown;
                } else if(i == numRows - 1) {
                    idx = idx + goingUp;
                } else {
                    if(down) idx = idx + goingDown;
                    else idx = idx + goingUp;
                    down = !down;
                }
            }
        }
        
        return answer.toString();
    }
}