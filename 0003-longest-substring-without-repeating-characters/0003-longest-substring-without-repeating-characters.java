class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> countMap = new HashMap<>();
        int begin = 0, end = 0, maxLength = 0;
        while(end < n) {
            char ch = s.charAt(end);
            countMap.put(ch, countMap.getOrDefault(ch, 0)+1);
            while(countMap.size() < end-begin+1 && begin < end) {
                char rm = s.charAt(begin);
                int cnt = countMap.get(rm);
                if(--cnt <= 0) countMap.remove(rm);
                else countMap.put(rm, cnt);
                begin++;
            }
            if(countMap.size() == end-begin+1) {
                maxLength = Math.max(maxLength, end - begin + 1);
            }
            end++;
        }
        return maxLength;
    }
}