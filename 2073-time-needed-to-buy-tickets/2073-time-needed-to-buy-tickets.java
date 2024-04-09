class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int sum = 0, n = tickets.length;
        while(tickets[k] != 0) {
            for(int i=0;i<n;i++) {
                if(tickets[i] > 0) {
                    tickets[i]--;
                    sum++;
                }
                if(tickets[k] == 0) return sum;
            }
        }
        return sum;
    }
}