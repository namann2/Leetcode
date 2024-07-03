class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int cnt = 0, n = sentence.length, length = 0;
        while(rows > 0) {
            for(int i = 0; i < n; i++) {
                String curr = sentence[i];
                int currLength = curr.length();
                // if curr word can not be placed because of cols limit
                if(currLength > cols) return cnt;
                
                if(length + currLength <= cols) { // can we add curr word to current row ?
                    // length += currLength + 1;
                } else { // add curr word to new row
                    rows--;
                    length = 0;
                    // length = currLength + 1;
                }
                length += currLength + 1;
                if(rows == 0) return cnt;
            }
            cnt++;
        }
        return cnt;
    }
}