class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> trans = new HashMap<>();
        
        for(int[] transaction : transactions) {
            int from = transaction[0], to = transaction[1], amount = transaction[2];
            trans.put(from, trans.getOrDefault(from, 0) - amount);
            trans.put(to, trans.getOrDefault(to, 0) + amount);
        }
        
        int size = trans.size();
        int[] needed = new int[size];
        int idx = 0;
        for(int key : trans.keySet()) {
            needed[idx++] = trans.get(key);
        }
        return settleAmount(needed, 0, size);
    }
    
    private int settleAmount(int[] needed, int index, int n) {
        if(index == n)
            return 0;
        
        if(needed[index] == 0)
            return settleAmount(needed, index + 1, n);
        
        int minTransactions = Integer.MAX_VALUE;
        for(int i = index + 1; i < n; i++) {
            if(needed[index] * needed[i] < 0) {
                needed[i] += needed[index];
                minTransactions = Math.min(minTransactions, 1 + settleAmount(needed, index + 1, n));
                needed[i] -= needed[index];
            }
        }
        
        return minTransactions;
    }
}