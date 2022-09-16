```
class Solution {
    public int garbageCollection(String[] g, int[] travel) {

        int len = travel.length;
        int[]R = new int[len+1];
        for(int i=0;i<len;i++)
            R[i+1] = R[i] + travel[i];
        
        // previous index of current garbage type
        // If -1, first visit hence, add prefix sum else add corresonding visit length
        
        int pM = -1, pP = -1, pG = -1; 
        int result = 0;
        
        for(int i=0;i<g.length;i++) {
            // get the pickup time and visit time of each garbage type of current house
            String s = g[i];
            int[]cnt = new int[3];
            for(char ch : s.toCharArray()) {
                if(ch == 'M') cnt[0]++;
                else if(ch == 'P') cnt[1]++;
                else cnt[2]++;
            }
            
            int pickTime = cnt[0] + cnt[1] + cnt[2];
            
            int travelTime = 0;
            
            if(i > 0) {
                travelTime =  cnt[0] > 0 ? (pM == -1 ? R[i] : R[i] - R[pM]) : 0;
                travelTime +=  (cnt[1] > 0 ? (pP == -1 ? R[i] : R[i] - R[pP]) : 0);
                travelTime +=  (cnt[2] > 0 ? (pG == -1 ? R[i] : R[i] - R[pG]) : 0);
            }
            
            int curr = travelTime + pickTime;
            result += curr;
            
            // update the index of garbage present at current house
            for(char ch : s.toCharArray()) {
                if(ch == 'M') pM = i;
                if(ch == 'P') pP = i;
                if(ch == 'G') pG = i;
            }
        }
        return result;
    }
}
```
