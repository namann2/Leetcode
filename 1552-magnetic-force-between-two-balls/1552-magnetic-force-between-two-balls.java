class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        
        int start = 1, end = position[n-1] - position[0], ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(canPlaceMBalls(position, mid, n, m)) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }
    
    private boolean canPlaceMBalls(int[] position, int force, int n, int m) {
        int prevPosition = 0, cnt = 1;
        for(int i = 1; i < n; i++) {
            if(position[i] - position[prevPosition] >= force) {
                cnt++;
                prevPosition = i;
            }
        }
        return cnt >= m;
    }
}