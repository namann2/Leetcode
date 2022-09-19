class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int t : trainers)
            map.put(t, map.getOrDefault(t, 0)+1);
        int cnt = 0;
        for(int p : players) {
            Integer value = map.ceilingKey(p);
            if(value == null) continue;
            cnt++;
            map.put(value, map.get(value)-1);
            if(map.get(value) == 0) map.remove(value);
        }
        return cnt;
    }
}