class Solution {
    public int countPairs(int[] deliciousness) {
        Map<Integer,Integer> map = new HashMap<>();
        int mod = (int)1e9 + 7;
        int ans = 0;
        int n = deliciousness.length;
        
        for(int i = 0; i < n; i++) {
            int cnum = deliciousness[i];
            for(int j = 0; j <= 21; j++) {
                int x = (int)(Math.pow(2, j));
                int req = x - cnum;
                
                if(map.containsKey(req)) {
                    ans += map.get(req);
                    ans %= mod;
                }
            }
            map.put(cnum, map.getOrDefault(cnum, 0) + 1);
        }
        return ans;
    }
}