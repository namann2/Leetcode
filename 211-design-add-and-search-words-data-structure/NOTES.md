****
Please upvote if the explanation helps, as it keeps up the motivation to provide such posts.
**Edit : Added code simulation at the end**
****

Explanation Flow : 
* Given statements
* Observations
* Approach 1 - HashMap
* Approach 2 - Trie
* Modular Code
* Complete Code


**✔️ Given statements :**

- Design a data structure that supports `adding new words` and `finding` if a string matches any previously added string.
- `word` in addWord consists lower-case English letters.
- `word` in search consist of  '.' or lower-case English letters

**✔️Observations :** 

The only difficulty we will have is to handle `'.'` character.

One idea is to use a hashmap, where we map the `length of word -> List of word`. Following is the code for this approach :

```
class WordDictionary {

    private HashMap<Integer, Set<String>> map;

    public WordDictionary() {
        this.map = new HashMap<>();
    }

    public void addWord(String word) {
	
        int l = word.length();
        if (!this.map.containsKey(l)) {
            this.map.put(l, new HashSet());
        }
        this.map.get(l).add(word);
    }
	/* get list of words that have same length and match "word" with every word in the list*/
    public boolean search(String word) {
        int l = word.length();
        if (this.map.containsKey(l)) {
            for (String w : this.map.get(l)) {
                int i = 0;
                while ((i < l) && (w.charAt(i) == word.charAt(i) || word.charAt(i) == '.')) {
                    i++;
                }
                if (i == l) return true;
            }
        }
        return false;
    }
}
```

**✔️ Complexity Analysis:**
* TC : `O(n * m)`, where `n` is the number of words and `m` is length of word we need to search.
* SC : `O(n)`

**✔️ Optimisation :** 

An efficient data structure to use here would be `Trie` because
* it provides better space optimisation as it stores common prefixes rather than complete words.
( unlike hashmap )
* Trie supports `search`, `insert` and delete operations in O(L) time where L is the length of the key.
 
`Note :` The search space of Trie is much smaller than the Map based approach but still the worst case of both solutions are the same.

I have broken down the code is modules : 

**TrieNode structure:**

```
class Node {
    HashMap<Character, Node> children;
    boolean isEnd;
    Node() {
        this.children = new HashMap<>();
        this.isEnd = false; // by default it is false
    }
}
```
****
**addWord function :** 

If you are familier with Trie this logic is same, if not, here is a one line explanation to it : 

At each step, we need to check, if the child node to add is already present. If yes, go one step down else add it into the trie and then go one step down.
[ Please refer this great article on Tries : https://leetcode.com/problems/implement-trie-prefix-tree/solution/ ]

```
	public void addWord(String word) {
	
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }
```

****
**searchWord :**

There are two posibility for a character :
1. ch == `'.'`
2. `a` <= ch <= `z`

If `ch` is `.` then, we need to look for the word ahead, in the trie. For eg: If we are at `curr` in Trie and need to search for `.ab` then, we need to search for `ab` in all possible path of `curr` i.e. in `curr.children.keySet()`.  [ see simulation ]

If `ch` is a character[`a`, `z`]  then, it is a simple implementation to just check whether that `ch` exists or not.

****
**Simulation:**
Images link ( If simulation speed is not aligned ) : https://drive.google.com/drive/folders/1INnKnTLryB4yaknIx04_WohE6XsYu2He?usp=sharing

` `
![image](https://assets.leetcode.com/users/images/a5278370-e5a0-4286-919f-46ce97858d6d_1643345130.5155442.gif)

****

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
                    if(search(word, trieNode, i+1))
                        return true;
                }
                return false;
            } else {
                if(!curr.children.containsKey(ch))
                    return false;
                curr = curr.children.get(ch);
            }
        }
        return curr.isEnd;
    }
```

****

**✔️ Complete Code :** 

```
class Node {
    HashMap<Character, Node> children;
    boolean isEnd;
    Node() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

class WordDictionary {

    private Node root;
    
    public WordDictionary() {
        this.root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = this.root;
        
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }
    
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
                    if(search(word, trieNode, i+1))
                        return true;
                }
                return false;
            } else {
                if(!curr.children.containsKey(ch))
                    return false;
                curr = curr.children.get(ch);
            }
        }
        return curr.isEnd;
    }
}
```

**✔️ Complexity Analysis :** 
* TC : `O(∑ L)` + `O(26^X)`, where `L` is the length of words we are inserting in Trie, `X` is the length of word we are searching.
* SC : `O(∑ L)`
