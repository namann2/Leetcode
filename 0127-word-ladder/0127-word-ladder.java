class Solution {
    // n = number of words
    // w = average length of the words in the wordList
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);   
        if(!wordList.contains(endWord))
            return 0;
        
        return bfs(beginWord, endWord, wordSet);
    }
    
    // TC : n * (computeOptions) : O(n^2 * w * 26)
    // SC : n + n + n^2 * w : O(n^2 * w)
    private int bfs(String beginWord, String endWord, Set<String> wordSet) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        int steps = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                String curr = q.poll();
                if(curr.equals(endWord))
                    return steps;
                
                // TC : w * 26 * n
                List<String> options = computeOptions(curr, wordSet, visited);
                for(String option : options) {
                    if(visited.add(option))
                        q.add(option);
                }
            }
            steps++;
        }
        return 0;
    }
    
    private List<String> computeOptions(String curr, Set<String> wordSet, Set<String> visited) {
        List<String> options = new ArrayList<>();
        char[] ch = curr.toCharArray();
        int n = ch.length;
        for(int i=0;i<n;i++) {
            char org = ch[i];
            for(char c='a';c<='z';c++) {
                if(c == org) continue;
                ch[i] = c;
                String newString = String.valueOf(ch);
                if(wordSet.contains(newString) && !visited.contains(newString))
                    options.add(newString);
                ch[i] = org;
            }
        }
        return options;
    }
}