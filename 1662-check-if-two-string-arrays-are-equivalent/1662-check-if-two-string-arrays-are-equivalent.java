class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder o = new StringBuilder(), t = new StringBuilder();
        for(String word : word1)
            o.append(word);
        for(String word : word2)
            t.append(word);
        return o.toString().equals(t.toString());
    }
}