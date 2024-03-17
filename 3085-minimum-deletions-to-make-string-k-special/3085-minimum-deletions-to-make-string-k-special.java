class Solution {
    public int minimumDeletions(String word, int k) {
        int[]cnt = new int[26];
        int n = word.length();
        for(char ch : word.toCharArray()) {
            cnt[ch-'a']++;
        }
        
        /*
            Try converting all the characters to each char present in the word.
            If the freq of any char j is smaller than the freq of the char in which we are trying to convert, then
            we will have to delete them anyway and for those, whose freq is greater than the freq of cha in which we are trying
            to convert then, add the extra chars ( which we will remove from it to convert to current )
        */
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i ++) {
            if(cnt[i] == 0) continue;
            int toDelete = 0;
            int ref_cnt = cnt[i];
            for(int j = 0; j < 26; j ++) {
                if(j == i || cnt[j] == 0) continue;
                if(cnt[j] < ref_cnt) toDelete += cnt[j];
                else if(cnt[j] - ref_cnt > k) toDelete += cnt[j] - ref_cnt - k;
            }
            answer = Math.min(answer, toDelete);
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}