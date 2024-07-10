class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] count = new int[n];
        for(int [] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
        }
        
        Arrays.sort(count);
        long ans = 0, contribution = 1l * n;
        for(int i = n-1; i >= 0; i--) {
            ans = ans + count[i] * contribution--;
        }
        
        return ans;
    }
}