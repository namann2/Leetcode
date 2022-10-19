We have atmost 4 digits and we can map them to atmost 4 digits
i.e. 4 digits for every character in the given string thus, 4^n
so, for each digit we have 4 recursive paths ahead.
this makes 4^n.
So, n*4^n ( this is for the ArrayList approach)
If we do like below : the it is 4^n
​
​
# Solution 1: ( My approach )
```
class Solution {
private static final String strs[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
public List<String> letterCombinations(String digits) {
List<String> result = new ArrayList<>();
if(digits == null || digits.length() == 0) return result;
int n = digits.length();
letterCombinationsUtil(new StringBuilder(), digits, 0, n, result);