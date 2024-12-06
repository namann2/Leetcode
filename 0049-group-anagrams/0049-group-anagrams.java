class Solution {
    public List<List<String>> groupAnagrams(String[] A) {
        int n = A.length;
        Map<String, List<String>> groups = new HashMap<>();
        for(int i = 0; i < n; i++) { // O(n)
            String curr = getCorrespondingGroupKey(A[i]);
            groups.putIfAbsent(curr, new ArrayList<>());
            groups.get(curr).add(A[i]);
        }
        return new ArrayList<>(groups.values());
    }
    
    private String getCorrespondingGroupKey(String curr) { // O(l), l is the average length of strings
        final String DEL = ",";
        int[] cnt = new int[26];
        int currLength = curr.length();
        for(int j = 0; j < currLength; j++) {
            cnt[curr.charAt(j) - 'a']++;
        }
        StringBuilder key = new StringBuilder();
        for(int j = 0; j < 26; j++) {
            key.append(cnt[j]);
            key.append(DEL);
        }
        return key.toString();
    }
}