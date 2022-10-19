Complexity Explained : 
w is the number of words in the wordSet 
and n is the length of startWord

TC : O(n * w * 26 * n) = O(n^2 * w) <br>
SC : O(w) + O(w) + O(26 * n) + O( n * n * w - intermediate strings we could make) - O(n^2 * w)
        


```
class Solution {
    public int ladderLength(String startWord, String endWord, List<String> wordList) {
        
        HashSet<String> wordSet = new HashSet<String>(wordList);
        
        if(startWord.equals(endWord) || !wordSet.contains(endWord)) 
            return 0;
        
        
        HashSet<String> visited = new HashSet<>();
        int distance = 1;
        
        Queue<String> q = new LinkedList<>();
        q.add(startWord);
        
        // TC of this while : n * w, n = length of startWord, w = total number of words in wordSet
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                
                String currWord = q.poll();

                if(currWord.equals(endWord))
                    return distance;

                if(visited.contains(currWord)) 
                    continue;
                
                visited.add(currWord);
                // find possible words from a single char change
                getAdjacentWords(q, currWord, visited, wordSet);
            }
            distance++;
        }
        
        return 0;
        
        // Total TC : n * w * 26 * n = n^2 * w
        // Total SC : w + w + w  + n^2 * w= n^2 * w // Queue + wordSet + charArray + queue
    }
    // n * w * 26n
    private void getAdjacentWords(Queue<String> q, String currWord, HashSet<String> visited, HashSet<String> wordSet) {
        int n = currWord.length();
        char[] charArray = currWord.toCharArray();
        // TC of this function : 26 * n
        for(int i=0;i<n;i++) {
            char org = charArray[i];
            for(char ch='a';ch<='z';ch++) {
                if(ch==org)
                    continue;
                charArray[i]=ch;
                String newWord = String.valueOf(charArray);
                if(wordSet.contains(newWord) && !visited.contains(newWord))
                {
                    q.add(newWord);
                }
            }
            charArray[i] = org;
        }
    }
}
```
