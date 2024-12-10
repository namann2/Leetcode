class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        /*
            Create a map of each row with flip and without flip
            The number of times we see a key is the max number of rows
            that can be equal
        */
        Map<String, Integer> patternMap = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < rows; i++) {
            StringBuilder same = new StringBuilder();
            StringBuilder complement = new StringBuilder();
            for(int j = 0; j < cols; j++) {
                same.append(matrix[i][j]);
                complement.append(1 - matrix[i][j]);
            }
            String key1 = same.toString();
            String key2 = complement.toString();
            patternMap.put(key1, patternMap.getOrDefault(key1, 0) + 1);
            patternMap.put(key2, patternMap.getOrDefault(key2, 0) + 1);
            ans = Math.max(ans, Math.max(patternMap.get(key1), patternMap.get(key1)));
        }
        return ans;
    }
}