class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // greedy
        int n = customers.length;
        int happy = 0, convert = 0, extra = 0;
        for(int i = 0; i < n; i++) {
            
            if(grumpy[i] == 0) happy += customers[i];
            else extra += customers[i];
            
            if(i >= minutes && grumpy[i-minutes] == 1) {
                extra -= customers[i-minutes];
            }
            convert = Math.max(convert, extra);
        }
        return happy + convert;
    }
}