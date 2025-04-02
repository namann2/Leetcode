class Solution {
    int INF = (int)1e9 + 7;
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> g = new HashMap<>();
        for(int[] transaction : transactions) {
            int from = transaction[0], to = transaction[1], amount = transaction[2];
            g.put(from, g.getOrDefault(from, 0) - amount);
            g.put(to, g.getOrDefault(to, 0) + amount);
            if(g.get(from) == 0) g.remove(from);
            if(g.get(to) == 0) g.remove(to);
        }

        int size = g.size();
        int[] A = new int[size];
        int idx = 0;
        for(int key : g.keySet()) {
            A[idx++] = g.get(key);
        }
        return settle(A, 0, size);
    }

    private int settle(int[] A, int index, int n) {
        // base case
        if(index == n) {
            return 0;
        }
        if(A[index] == 0)
            return settle(A, index + 1, n);
            
        // main logic
        int transaction = INF;
        for(int i = index + 1; i < n; i++) {
            if(A[i] * A[index] > 0) continue;
            A[i] += A[index];
            int value = settle(A, index + 1, n);
            if(value != INF)
                transaction = Math.min(transaction, 1 + value);
            A[i] -= A[index];
        }
        return transaction;
    }
}