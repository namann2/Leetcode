class Solution {
    public int maxLength(List<String> A) {
        int n = A.size();
        boolean[]used = new boolean[26];
        
        int maxLength = 0;
        for(int i = 0; i < n; i++) {
            if(!hasUniqueCharacters(A.get(i))) continue;
            updateUsage(A.get(i), used, true);
            maxLength = Math.max(maxLength, A.get(i).length() + findMaxAhead(A, i+1, used));
            updateUsage(A.get(i), used, false);
        }
        return maxLength;
    }
    
    private int findMaxAhead(List<String> A, int index, boolean[] used) {
        if(index == A.size())
            return 0;
        
        int currLength = 0, n = A.size();
        
        for(int i = index; i < n; i++) {
            if(hasUniqueCharacters(A.get(i)) && canUse(A.get(i), used)) {
                updateUsage(A.get(i), used, true);
                currLength = Math.max(currLength, A.get(i).length() + findMaxAhead(A, i + 1, used));
                updateUsage(A.get(i), used, false);
            }
        }
        
        return currLength;
    }
    
    private void updateUsage(String s, boolean[] used, boolean with) {
        int currLength = s.length();
        for(int i = 0; i < currLength; i++) {
            used[s.charAt(i) - 'a'] = with;
        }
    }
    
    private boolean hasUniqueCharacters(String s) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()) {
            if(count[ch-'a'] > 0) return false;
            count[ch - 'a']++;
        }
        return true;
    }
    
    private boolean canUse(String s, boolean[] used) {
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(used[s.charAt(i)-'a']) return false;
        }
        return true;
    }
}