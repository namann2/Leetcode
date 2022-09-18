class Solution {
    public String rankTeams(String[] votes) {
        
        if(votes == null || votes.length == 0)
            return null;
        
        int n = votes.length;
        if(n == 1) 
            return votes[0];
        
        // TC : O(n * ranks) + O(ranks) ~ ranks at max = 26 
        // TC : O(n)
        // SC : O(26) ~ O(1)
        
        int ranks = votes[0].length();
        Map<Character, int[]> vote_count = new HashMap<>();
        
        for(String vote : votes) {
            for(int i=0;i<ranks;i++) {
                char ch = vote.charAt(i);
                vote_count.putIfAbsent(ch, new int[ranks]);
                vote_count.get(ch)[i]++;
            }
        }
        
        List<Character> charList = new ArrayList<>(vote_count.keySet());
        
        Collections.sort(charList, (ch1, ch2) -> {
            for(int i=0;i<ranks;i++) {
                if(vote_count.get(ch1)[i] > vote_count.get(ch2)[i]) return -1;
                if(vote_count.get(ch1)[i] < vote_count.get(ch2)[i]) return 1;
            }
            return ch1 - ch2;
        });
        
        StringBuilder answer = new StringBuilder();
        
        for(char ch : charList) {
            answer.append(ch);
        }
        
        return answer.toString();
    }
}