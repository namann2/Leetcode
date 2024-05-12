class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> trans = new HashMap<>();
        for(int[] transaction : transactions) {
            int from = transaction[0], to = transaction[1], amount = transaction[2];
            trans.put(from, trans.getOrDefault(from, 0) - amount);
            trans.put(to, trans.getOrDefault(to, 0) + amount);
        }
        
        List<Integer> remain = new ArrayList<>();
        for(int transaction : trans.keySet())
            if(trans.get(transaction) != 0)
                remain.add(trans.get(transaction));
        
        int n = remain.size();
        int[] A = new int[n];
        for(int i = 0; i < n; i++)
            A[i] = remain.get(i);
        
        return solve(A, 0, n);
    }
    
    private int solve(int[] A, int index, int n) {
        if(index == n) return 0;
        
        if(A[index] == 0)
            return solve(A, index + 1, n);
        
        int min = Integer.MAX_VALUE;
        // A[index] ko kahan kahan use krke settlement kiya ja sakta hai
        for(int i = index + 1; i < n; i++) {
            if(A[index] * A[i] < 0) {
                A[i] += A[index];
                int curr = 1 + solve(A, index + 1, n);
                min = Math.min(min, curr);
                A[i] -= A[index];
            }
        }
        return min;
    }
}