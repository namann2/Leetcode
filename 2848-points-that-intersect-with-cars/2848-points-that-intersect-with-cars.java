class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int n = nums.size();
        int[] line_sweep = new int[102];
        // line_sweep[i] represents number of cars at ith position
        for(List<Integer> num : nums) {
            int start = num.get(0), end = num.get(1);
            line_sweep[start] += 1;
            line_sweep[end+1] -= 1;
        }
        
        for(int i = 1;i < 102;i++) {
            line_sweep[i] += line_sweep[i-1];
        }
        
        int cnt = 0;
        for(int i = 0; i < 102;i++) {
            if(line_sweep[i] > 0) cnt++;
        }
        return cnt;
    }
}