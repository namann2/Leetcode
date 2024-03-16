class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int cnt = 1;
        for(char ch : s.toCharArray()) {
            if(!set.add(ch)) {
                cnt++;
                set.clear();
                set.add(ch);
            }
        }
        return cnt;
    }
}