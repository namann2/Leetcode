class Solution {
    public boolean confusingNumber(int n) {
        // log n
        int p = 0, o = n;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        
        while(n > 0) {
            int m = n % 10;
            if(!map.containsKey(m))
                return false;
            p = p * 10 + map.get(m);
            n /= 10;
        }
        return p != o;
    }
}