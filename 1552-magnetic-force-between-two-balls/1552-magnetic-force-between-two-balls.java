class Solution {
    public int maxDistance(int[] position, int m) {
        // The min distance between any two balls will be from the consecutive baskets, hence
        // sorting the array
        Arrays.sort(position);
        
        int n = position.length, 
        start = 1,  // min distance b/w any two balls
        end = position[n-1] - position[0]; // max distance b/w any two balls
        
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(true == countArrangement(position, mid, m)) { // we can increase the distance b/w balls
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }
    
    private boolean countArrangement(int[] position, int distance, int reqBalls) {
        int cnt = 1, // greedily starting of with placing the value at 0th index
        n = position.length, lastPosition = position[0];
        
         for(int i=1;i<n;i++) {
            if(position[i] - lastPosition >= distance) {
                cnt++;
                if(reqBalls == cnt) return true;
                lastPosition = position[i];
            }
        }
        return reqBalls == cnt;
    }
}
