class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length(), begin = 0, end = 0, maxLength = 0;
        
        while(end < n) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(map.size() < end-begin+1 && begin < end) {
                char rm = s.charAt(begin);
                int cnt = map.get(rm) - 1;
                if(cnt == 0) map.remove(rm);
                else map.put(rm, cnt);
                begin++;
            }
            if(map.size() == end - begin + 1)
                maxLength = Math.max(maxLength, map.size());
            end++;
        }
        return maxLength;
    }
}