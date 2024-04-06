class Solution {
    public int maxLength(List<String> A) {
        boolean[]used = new boolean[26];

        int max = 0, n = A.size();
        for(int i=0;i<n;i++) {
            if(!hasUniqueCharacaters(A.get(i))) continue;
            updateUsage(A.get(i), used, true);
            max = Math.max(max, A.get(i).length() + findMax(A, i+1, n, used));
            updateUsage(A.get(i), used, false);
        }
        return max;
    }
    private int findMax(List<String> A, int index, int n, boolean[] used) {
        // base case
        if(index == n) return 0;
        // main logic
        int max = 0;
        for(int i = index;i < n; i++) {
            if(hasUniqueCharacaters(A.get(i)) && canUse(A.get(i), used)) {
                updateUsage(A.get(i), used, true);
                max = Math.max(max, A.get(i).length() + findMax(A, i+1, n, used)); 
                updateUsage(A.get(i), used, false);
            }
        }
        return max;
    }
    private boolean hasUniqueCharacaters(String s) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()) {
            if(count[ch-'a'] > 0) return false;
            count[ch - 'a']++;
        }
        return true;
    } // check if there are unique chars in string
    private void updateUsage(String s, boolean[] used, boolean setTo) {
        for(int i=0;i<s.length();i++) {
            int ch = s.charAt(i) - 'a';
            used[ch] = setTo;
        }
    }
    private boolean canUse(String s, boolean[] used) {
        for(int i=0;i<s.length();i++) {
            int ch = s.charAt(i) - 'a';
            if(used[ch]) return false;
        }
        return true;
    } // check if there are unique chars between strings
}