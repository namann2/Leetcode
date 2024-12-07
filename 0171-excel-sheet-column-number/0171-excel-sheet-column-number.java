class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int R = 0, power = 0;
        
        for(int i = n-1; i >= 0; i--) {
            int curr = columnTitle.charAt(i) - 'A' + 1;
            int column = (int)Math.pow(26, power);
            R += (curr * column);
            power++;
        }
        return R;
    }
}