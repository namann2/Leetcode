class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        int n = s.length();
        // create a map of character to set of index they are at
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.putIfAbsent(ch, new TreeSet<>());
            map.get(ch).add(i);
        }
        
        int match = 0;
        for(String word : words) {
            int wordLength = word.length();
            int prevIndex = -1;
            int charMatched = 0;
            for(int i = 0; i < wordLength; i++) {
                char ch = word.charAt(i);
                if(map.get(ch) == null) {
                    break;
                }
                Integer nextIndex = map.get(ch).higher(prevIndex);
                if(nextIndex == null) {
                    break;
                }
                charMatched++;
                prevIndex = nextIndex;
            }
            if(charMatched == wordLength) match++;
        }
        return match;
    }
}