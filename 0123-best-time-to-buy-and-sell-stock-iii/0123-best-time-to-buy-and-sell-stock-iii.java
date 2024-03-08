class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MIN_VALUE;
        int A = min, B = min, C = min, D = min;
        for(int price : prices) {
            A = Math.max(A, - price); // buy or not buy
            B = Math.max(B, A + price); // sell or not sell, B is the resultant profit after a transaction
            C = Math.max(C, B - price); // buy or not buy second time
            D = Math.max(D, C + price);
        }
        return D;
    }
}