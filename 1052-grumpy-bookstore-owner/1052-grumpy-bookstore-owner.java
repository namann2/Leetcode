class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // greedy
        int n = customers.length;
        int happy = 0, convert = 0, extra = 0;
        
        for(int i = 0; i < n; i++) {
            // if grumpy[i] == 0 -> all customers are happy customers
            if(grumpy[i] == 0) happy += customers[i];
            // else the customers are extra customers that can be potentially converted to happy customers
            else extra += customers[i];
            
            // keep on updating the extra customers based on the minutes window
            if(i >= minutes && grumpy[i-minutes] == 1) {
                extra -= customers[i-minutes];
            }
            // get max customers that can be converted
            convert = Math.max(convert, extra);
        }
        return happy + convert;
    }
}