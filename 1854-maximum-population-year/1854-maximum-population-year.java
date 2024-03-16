class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] line_sweep = new int[101];
        int base = 1950;

        for(int[] log : logs) {
            int start = log[0] - base, end = log[1] - base;
            line_sweep[start++] += 1;
            line_sweep[end] -= 1;
        }
        
        // line_sweep[i] represents the number of people alive in ith year
        for(int i = 1; i < 101; i++) 
            line_sweep[i] += line_sweep[i-1];
        
        int max = 0, index = 0;
        for(int i = 0; i < 101; i++) {
            if(line_sweep[i] > max) {
                max = line_sweep[i];
                index = i;
            }
        }
        return index + base;
    }
}