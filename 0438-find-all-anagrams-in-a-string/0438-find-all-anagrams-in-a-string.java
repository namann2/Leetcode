class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        int[] countP = getFrequency(p);
        int end = 0, begin = 0, k = p.length(), n = s.length();
        int[] tumble = new int[26];
        
        // iteration
        while(end < n) {
            char ch = s.charAt(end);
            tumble[ch-'a']++;
            // maintain the size of fixed window
            while(end-begin+1 > k) {
                tumble[s.charAt(begin)-'a']--;
                begin++;
            }
            // if the size of window equals required k
            if(end-begin+1 == k) {
                if(Arrays.compare(countP, tumble) == 0) {
                    answer.add(begin);
                }
            }
            end++;
        }
        return answer;
    }

    /** helper function */
    private int[] getFrequency(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        return freq;
    }
}