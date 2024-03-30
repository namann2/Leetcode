class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        int begin = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        while(end < n) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(map.size() > 2 && begin < end) {
                char rm = s.charAt(begin);
                int cnt = map.get(rm);
                map.put(rm, --cnt);
                if(cnt == 0) map.remove(rm);
                begin++;
            }
            if(map.size() <= 2) 
                maxLength = Math.max(maxLength, end - begin + 1);
            end++;
        }
        return maxLength;
    }
}