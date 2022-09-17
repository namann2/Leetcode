class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // TC : O(N^2), SC : O(N)
        Map<Integer,Set<Integer>> g = new HashMap<>();
        for(int[]road : roads) {
            g.putIfAbsent(road[0], new HashSet<>());
            g.putIfAbsent(road[1], new HashSet<>());
            g.get(road[0]).add(road[1]);
            g.get(road[1]).add(road[0]);
        }
        // since we need to find the max rank of ALL PAIRS of different cities
        // whether they are connected or not. See ex 3
        int answer = 0;
        for(int i=0;i<n;i++) {
            if(!g.containsKey(i)) continue;
            for(int j=i+1;j<n;j++) {
                if(!g.containsKey(j)) continue;
                int network = g.get(i).size() + g.get(j).size() - (g.get(i).contains(j) ? 1 : 0);
                answer = Math.max(answer, network);
            }
        }
        
        return answer;
    }
}