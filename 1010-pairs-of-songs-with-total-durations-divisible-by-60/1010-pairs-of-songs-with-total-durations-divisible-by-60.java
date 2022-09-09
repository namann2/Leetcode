class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0, n = time.length;
        for(int ct : time) {
            int remainder = ct % 60;
            int required = remainder == 0 ? 0 : 60 - remainder; // (60-x) -> to keep the remainder positive
            
            if(map.containsKey(required)) cnt += map.get(required);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return cnt;
    }
}