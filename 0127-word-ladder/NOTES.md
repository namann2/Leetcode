Complexity Explained :
w is the number of words in the wordSet
and n is the length of startWord
​
TC : O(n * w * 26 * n) = O(n^2 * w)
SC : O(w) + O(w) + O(26 * n) + O( n * n * w - intermediate strings we could make) - O(n^2 * w)
​
​
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