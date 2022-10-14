class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long H = 0, max = 0;
        for(int d : damage) {
            H += d;
            max = Math.max(max, d);
        }
        H++;
        H -= Math.min(max, armor);
        return H;
    }
}