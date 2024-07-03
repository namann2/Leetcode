https://www.youtube.com/watch?v=Csqlac6k1U4
​
```
class Solution {
public int numMatchingSubseq(String s, String[] words) {
/*
We are using map(char -> queue) because using a map (char -> list) will give us
ConcurrentModificationException because the size of list would get changed while traversing the list.
Hence, we use queue to resolve this.
Basically, whenever we have a scenario where we iterate over a Collection/List and we need to delete/add somehting then it is better to use queue in that case.
See, stephan's explanation :
I go through S once, and while I'm doing that, I move through all words accordingly. That is, I keep track of how much of each word I've already seen, and with each letter of S, I advance the words waiting for that letter. To quickly find the words waiting for a certain letter, I store each word (and its progress) in a list of words waiting for that letter. Then for each of the lucky words whose current letter just occurred in S, I update their progress and store them in the list for their next letter.
TC : S * n * w
SC : O(words)
*/
HashMap<Character, Queue<String>> buckets = new HashMap<>();
// add all chars as key in hashmap