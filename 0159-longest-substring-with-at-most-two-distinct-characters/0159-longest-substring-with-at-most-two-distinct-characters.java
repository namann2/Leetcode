class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length(), end = 0, begin = 0, maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(end < n) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(map.size() > 2 && begin < end) {
                char rm = s.charAt(begin);
                int cnt = map.get(rm);
                if(--cnt == 0) map.remove(rm);
                else map.put(rm, cnt);
                begin++;
            }
            if(map.size() <= 2)
                maxLength = Math.max(maxLength, end - begin + 1);
            end++;
        }
        return maxLength;
    }
}