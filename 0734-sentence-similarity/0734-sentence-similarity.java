class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int n = sentence1.length, m = sentence2.length;
        if(n != m) 
            return false;
        Map<String, Set<String>> map = new HashMap<>();
        int k = similarPairs.size();
        for(int i = 0; i < k ; i++) {
            map.putIfAbsent(similarPairs.get(i).get(0), new HashSet<>());
            map.putIfAbsent(similarPairs.get(i).get(1), new HashSet<>());
            map.get(similarPairs.get(i).get(0)).add(similarPairs.get(i).get(1));
            map.get(similarPairs.get(i).get(1)).add(similarPairs.get(i).get(0));
        }
        for(int i = 0; i < n; i++) {
            if(sentence1[i].equals(sentence2[i]) || 
              (map.containsKey(sentence1[i]) && map.get(sentence1[i]).contains(sentence2[i]))) continue;
            return false;
        }
        return true;
    }
}