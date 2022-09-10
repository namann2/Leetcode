If we have n words of averge length L, then
​
time taken to build the trie will be n* L * L = O(n* L^2)
​
time taken to search the word (prefix+suffix) = O(K), where K is the length of word that we are searching
​
​
SPACE. :
​
Size of trie : O(n* L^2)
​
```
class WordFilter {
// Check Notes for complexity Anaylsis
TrieNode trie;
public WordFilter(String[] words) {
trie = new TrieNode();
for(int i=0;i<words.length;i++) {
String word = words[i] + "|" + words[i]; // suffix + "|" + prefix
System.out.println(word);
trie.insert(word, i);
}
}
public int f(String prefix, String suffix) {
String word = suffix + "|" + prefix;
return trie.search(trie.root, word, 0);
}
}
class TrieNode {
Node root;
TrieNode() {
this.root = new Node();
}
public void insert(String word, int index) {