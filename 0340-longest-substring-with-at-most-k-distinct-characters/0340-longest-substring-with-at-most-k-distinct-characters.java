class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int end = 0, begin = 0, n = s.length(), maxLength = 0;
        while(end < n) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.size() > k && begin < end) {
                char rm = s.charAt(begin);
                int cnt = map.get(rm);
                if(--cnt == 0) map.remove(rm);
                if(cnt > 0) map.put(rm, cnt);
                begin++;
            }
            if(map.size() <= k)
                maxLength = Math.max(maxLength, end - begin + 1);
            end++;
        }
        return maxLength;
    }
}