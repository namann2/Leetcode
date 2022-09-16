class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int answer = 0;
        int n = travel.length;
        int[]tps = new int[n+1];
        for(int i=0;i<n;i++)
            tps[i+1] = travel[i] + tps[i];
        
        int prM = -1, prP = -1, prG = -1;
        for(int i=0;i<n+1;i++) {
            String _g = garbage[i];
            int cnt[] = new int[3];
            for(char ch : _g.toCharArray()) {
                if(ch == 'G') cnt[0]++;
                else if(ch == 'P') cnt[1]++;
                else cnt[2]++;
            }
            
            int travelTime = 0, 
            pickTime = cnt[0] + cnt[1] + cnt[2];
            
            // travel time needs to be updated
            if(i!=0) {
                int cm = cnt[2] > 0 ? (prM == -1 ? tps[i] : tps[i] - tps[prM]) : 0;
                int cp = cnt[1] > 0 ? (prP == -1 ? tps[i] : tps[i] - tps[prP]) : 0;
                int cg = cnt[0] > 0 ? (prG == -1 ? tps[i] : tps[i] - tps[prG]) : 0;
                
                travelTime += cm + cp + cg;
            }
            answer += travelTime + pickTime;
            
            if(cnt[0] > 0) prG = i;
            if(cnt[1] > 0) prP = i;
            if(cnt[2] > 0) prM = i;
        }
        return answer;
    }
}