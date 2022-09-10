}
```
​
****
**searchWord :**
​
There are two posibility for a character :
1. ch == `'.'`
2. `a` <= ch <= `z`
​
If `ch` is `.` then, we need to look for the word ahead, in the trie. For eg: If we are at `curr` in Trie and need to search for `.ab` then, we need to search for `ab` in all possible path of `curr` i.e. in `curr.children.keySet()`.  [ see simulation ]
​
If `ch` is a character[`a`, `z`]  then, it is a simple implementation to just check whether that `ch` exists or not.
​
****
**Simulation:**
Images link ( If simulation speed is not aligned ) : https://drive.google.com/drive/folders/1INnKnTLryB4yaknIx04_WohE6XsYu2He?usp=sharing
​
` `
![image](https://assets.leetcode.com/users/images/a5278370-e5a0-4286-919f-46ce97858d6d_1643345130.5155442.gif)
​
****
​
```
public boolean search(String word) {
return search(word, this.root, 0);
}
private boolean search(String word, Node curr, int index) {
for(int i=index;i<word.length();i++) {
char ch = word.charAt(i);
if(ch == '.') {
// look for the word ahead
for(char c : curr.children.keySet()) {
Node trieNode = curr.children.get(c);
}