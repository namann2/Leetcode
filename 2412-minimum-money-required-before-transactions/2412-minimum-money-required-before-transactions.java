class Solution {
    public long minimumMoney(int[][] transactions) {
        // first intuition goes to binary search since the output looks like F F F F T T T T T T T T
        // but it is given that the order does not matter
        // if the order does not matter then, we can not implement binary search
        // we will have to fall back our logic to greedy algorithm
        
        // greedy algorithm uses : sort, pq, sort + pq, trick
        
        // binary search with a trick
        // since we want to have the minimum amount of money to begin with, hence,
        // we should first do those transactions which give us >= 0 or +ive amount after the transactions BUT
        // since the order does not matter, the logic would change.
        // We would need to find the worst ordering so that we can be sure, that if it works for worst arrangement
        // then, it works for any configuration
        
        List<int[]> A = new ArrayList<>();
        List<int[]> B = new ArrayList<>();
        int n = transactions.length;
        
        for(int i=0;i<n;i++) {
            if(transactions[i][1] < transactions[i][0]) A.add(transactions[i]);
            else B.add(transactions[i]);
        }
        
        // arrange the transactions in worst case possible
        // those transactions which have cashback less than cost
        Collections.sort(A, (i1, i2) -> {
            if(i1[1] == i2[1]) 
                return i2[0] - i1[0];
            return i1[1] - i2[1];
        });
        
        // those transactions which have cashback >= cost
        Collections.sort(B, (i1, i2) -> {
            return i2[0] - i1[0];
        });
        
        long start = 0, end = Long.MAX_VALUE, ans = (long)1e9;
        while(start <= end) {
            long mid = start + (end - start) / 2;
            if(canMake(A, B, mid)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
    
    private boolean canMake(List<int[]> A, List<int[]> B, long amount) {
        // if we are able to do all transactions with the amount
        for(int[] transaction : A) {
            if(amount < transaction[0]) return false;
            amount = amount - transaction[0] + transaction[1];
        }
        
        for(int[] transaction : B) {
            if(amount < transaction[0]) return false;
            amount = amount - transaction[0] + transaction[1];
        }
        return true;
    }
}