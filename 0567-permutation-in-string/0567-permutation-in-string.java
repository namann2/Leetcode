class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.equals(s2)) return true;
        
        if(s1==null || s2==null || s1.length() == 0 || s2.length() == 0) return false;
        int n = s2.length();
        
        char[] target = new char[26];
        for(char ch : s1.toCharArray()) target[ch-'a']++;
        
        int begin=0;
        int end=0;
        int k = s1.length();
        char[] currFreq = new char[26];
        while(end < n) {
            currFreq[s2.charAt(end)-'a']++;
            if(end-begin+1 < k) end++;
            else if(end-begin+1 == k) {
                if(Arrays.equals(currFreq, target)) return true;
                end++;
                currFreq[s2.charAt(begin)-'a']--;
                begin++;
            }
        }
        return false;
    }
}