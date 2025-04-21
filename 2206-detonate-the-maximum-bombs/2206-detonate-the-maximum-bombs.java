class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int bombLength = bombs.length;
        for(int i = 0; i < bombLength; i++) {
            g.putIfAbsent(i, new ArrayList<>());
            for(int j = 0; j < bombLength; j++) {
                if(i != j && inRange(bombs[i], bombs[j])) {
                    g.get(i).add(j);
                }
            }
        }

        int maxBombs = 0;
        for(int i = 0; i < bombLength; i++) {
            maxBombs = Math.max(maxBombs, dfs(g, bombs, i, new boolean[bombLength]));
        }
        return maxBombs;
    }

    private boolean inRange(int[] A, int[] B) {
        long a = 1l * (B[1] - A[1]) * (B[1] - A[1]);
        long b = 1l * (B[0] - A[0]) * (B[0] - A[0]);
        long r = 1l * A[2] * A[2];
        return a + b <= r;
    }

    private int dfs(Map<Integer, List<Integer>> g, int[][] bombs, int bombIndex, boolean[] isBombDetonated) {
        int bomb = 1;
        isBombDetonated[bombIndex] = true;
        if(g.containsKey(bombIndex)) {
            for(int bombInRange : g.get(bombIndex)) {
                if(!isBombDetonated[bombInRange])
                    bomb += dfs(g, bombs, bombInRange, isBombDetonated);
            }
        }
        return bomb;
    }
}