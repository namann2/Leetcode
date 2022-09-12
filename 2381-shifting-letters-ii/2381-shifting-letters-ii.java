class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        // find the resultant shift of each ch[i]
        int n = s.length();
        long[]ps = new long[n+1];
        for(int[]shift : shifts) {
            int direction = shift[2];
            if(direction == 1) {
                ps[shift[0]] += 1;
                ps[shift[1]+1] -= 1;
            } else {
                ps[shift[0]] -= 1;
                ps[shift[1]+1] += 1;
            }
        }
        
        // calculating the number of shifts of each index
        for(int i=1;i<n+1;i++)
            ps[i] += ps[i-1];
        
        // System.out.println(Arrays.toString(ps));
        
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n;i++) {
            long shift = ((s.charAt(i) - 'a') + ps[i]) % 26;
            shift = (shift + 26) % 26;
            ans.append((char)(shift + 'a'));
        }
        
        return ans.toString();
    }
}