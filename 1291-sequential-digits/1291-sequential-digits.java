class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> answer = new ArrayList<>();
        String sequence = "123456789";
        
        int digitsLow = getCount(low); 
        int digitsHigh = getCount(high);
        
        while(digitsLow <= digitsHigh) {
            for(int i = 0; i < 9; i++) {
                if(i + digitsLow > 9) break;
                String curr = sequence.substring(i, i + digitsLow);
                int icurr = Integer.valueOf(curr);
                if(icurr >= low && icurr <= high) {
                    answer.add(icurr);
                } else if(icurr > high) break;
            }
            digitsLow++;
        }
        return answer;
    }
    
    private int getCount(int number) {
        int cnt = 0;
        while(number > 0) {
            cnt++;
            number /= 10;
        }
        return cnt;
    }
}