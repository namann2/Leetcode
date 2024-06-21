class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int end = 0, begin = 0, maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while(end < n) {
            char curr = s.charAt(end);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            while(map.size() < end-begin+1 && begin <= end) { // duplicates exist
                char rm = s.charAt(begin);
                map.put(rm, map.get(rm) - 1);
                if(map.get(rm) == 0) map.remove(rm);
                begin++;
            }
            if(map.size() == end-begin+1) {
                maxLength = Math.max(maxLength, end-begin+1);
            }
            end++;
        }
        return maxLength;
    }
}