class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int end = 0, begin = 0, n = s.length(), maxLength = 0;
        while(end < n) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(end-begin+1 > map.size()) {
                char rm = s.charAt(begin);
                int cnt = map.get(rm);
                if(--cnt == 0) map.remove(rm);
                else map.put(rm, cnt);
                begin++;
            }
            if(end-begin + 1 == map.size()) {
                maxLength = Math.max(maxLength, map.size());
            }
            end++;
        }
        return maxLength;
    }
}