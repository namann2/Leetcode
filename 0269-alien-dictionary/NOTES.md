Simpler Problem ( A kind of pre-requisite ) : https://practice.geeksforgeeks.org/problems/alien-dictionary
​
​
TC for dfs ?
Total vertices in the graph are the total number of unique chars ( = O(V) )
Total edges ?
we are comparing two adjacent words to form an edge, hence, there will be atmost n-1 edges where n is the number of words we are given.
Hence, TC : O(V + n-1) = O(V+n)
Total TC : O(V + N) + O(N * L)
​
To be more generic, our graph won't have more than V^2 edges. Hence,
​
TC : `O(V + Math.min(V^2, N-1))`
​
​
```
class Solution {
enum COLOR {
WHITE, GREY, BLACK;
}
public String alienOrder(String[] words) {
// TC : O(C) -> total length of words in input list
// graph adjacency
HashMap<Character, List<Character>> adj = new HashMap<>();
// get different chars
boolean[] diffChars = new boolean[26];
for(String w : words) { // n*L ->n total words, L-> avg length of words
for(char ch : w.toCharArray())
diffChars[ch-'a'] = true;
}
int n = words.length;
// TC : O(n * L) -> where n is the number of words and L is the average length of words
for(int i=1;i<n;i++) { // nL
String w1 = words[i-1];
String w2 = words[i];