class Solution {
    public String fractionToDecimal(int n, int d) {
        /* 
            edge cases I missed
            0, -5 => should be 0
        */
        StringBuilder answer = new StringBuilder();
        
        if(n == 0) return "0";
        
        if((n ^ d) < 0) answer.append("-"); // check if they have opp sign
        
        long N = n < 0 ? -1l * n : 1l*n;
        long D = d < 0 ? -1l * d : 1l*d;
        
        long q = N / D;
        long r = N % D;
        
        answer.append(q);
        
        if(r == 0) return answer.toString();
        
        answer.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        while(r != 0) {
            if(map.containsKey(r)) {
                int len = map.get(r);
                answer.insert(len, "(");
                answer.append(")");
                break;
            }
            map.put(r, answer.length());
            r *= 10;
            q = r / D;
            r = r % D;
            answer.append(q);
        }
        return answer.toString();
    }
}