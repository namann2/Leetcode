class Solution {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }
        
        int[] needs = new int[map.size()]; // transactions that need settlement
        int idx = 0;
        for(int transaction : map.keySet()) {
            needs[idx++] = map.get(transaction);
        }
        
        return settle(needs, 0, needs.length);
    }
    private int settle(int[] needs, int index, int n) {
        // base case
        if(index == n) {
            return 0;
        }
        if(needs[index] == 0) {
            return settle(needs, index+1, n);
        }
        // main logic
        int minSettle = Integer.MAX_VALUE;
        for(int i = index+1; i < n; i++) {
            if(needs[index] * needs[i] < 0) {
                needs[i] += needs[index];
                minSettle = Math.min(minSettle, 1 + settle(needs, index+1, n));
                needs[i] -= needs[index];
            }
        }
        return minSettle;
    }
}