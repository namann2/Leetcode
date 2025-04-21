```
class Solution {

    private boolean inRange(int[] a, int[] b) {
        long A = 1l * (b[1] - a[1]) * (b[1] - a[1]);
        long B = 1l * (b[0] - a[0]) * (b[0] - a[0]);
        long R = 1l * a[2] * a[2];
        return A + B <= R;
    }

    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int n = bombs.length;

        for (int i = 0; i < n; i++) {
            g.putIfAbsent(i, new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (i == j || !inRange(bombs[i], bombs[j]))
                    continue;
                g.get(i).add(j);
            }
        }

        int maxDetonated = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            maxDetonated = Math.max(maxDetonated, dfs(g, i, visited));
        }

        return maxDetonated;
    }

    private int dfs(Map<Integer, List<Integer>> g, int sourceBomb, boolean[] visited) {
        visited[sourceBomb] = true;
        int detonatedBomb = 1;
        if (g.containsKey(sourceBomb)) {
            for (int neighborBomb : g.get(sourceBomb)) {
                if (!visited[neighborBomb]) {
                    detonatedBomb += dfs(g, neighborBomb, visited);
                }
            }
        }
        return detonatedBomb;
    }
}
```​
