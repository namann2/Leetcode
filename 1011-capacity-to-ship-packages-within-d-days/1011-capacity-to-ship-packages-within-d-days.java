class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0, sum = 0;
        for(int weight : weights)
        {
            maxWeight = Math.max(maxWeight, weight);
            sum += weight;
        }
        
        int start = maxWeight, end = sum, ans = -1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(canShip(weights, mid, days)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        
        return ans;
    }
    
    private boolean canShip(int[]weights, int maxW, int days) {
        int d = 1, cap = 0;
        for(int weight : weights) {
            cap += weight;
            if(cap > maxW) {
                d++;
                cap = weight;
            }
            if(d > days) return false;
        }
        return true;
    }
}