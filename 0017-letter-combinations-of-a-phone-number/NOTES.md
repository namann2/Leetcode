# Complexity : 

We have atmost 4 digits and we can map them to atmost 4 digits
i.e. 4 digits for every character in the given string thus, 4^n
so, for each digit we have 4 recursive paths ahead.
this makes 4^n.
        
So, n * 4^n ( this is for the ArrayList approach)
If we do like below : the it is 4^n

TC : O(n * 4^n) <br>
SC : O(n) <br>

where `n`is the length of the input string


# Solution 1: ( Much Suited )

```
class Solution {
    
    private static final String strs[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        
        int n = digits.length();
        
        letterCombinationsUtil(new StringBuilder(), digits, 0, n, result);
        
        return result;
    }
    
    private void letterCombinationsUtil(StringBuilder op, String digits, int index, int n, List<String> result) {
        // base case
        if(index >= digits.length()) {
            result.add(op.toString());
            return;
        }
        
        // main logic
        char currChar = digits.charAt(index);
        String currMapping = strs[currChar-'0'];
        
        for(int i=0;i<currMapping.length();i++) {
            op.append(currMapping.charAt(i));
            letterCombinationsUtil(op, digits, index+1 ,n, result);
            op.deleteCharAt(op.length()-1);
        }
    }
}
```
****


# Solution 2 : 

```
class Solution {
    private final String[] Map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        
        StringBuilder op = new StringBuilder();
        letterCombination(digits, op, result);
        
        return result;
    }
    private void letterCombination(String digits, StringBuilder op, List<String> result) {
        
        if(digits.equals("")) {
            result.add(op.toString());
            return;
        }
        // 23
        char firstChar = digits.charAt(0);
        String rstr = digits.length() >= 2 ? digits.substring(1) : "";
        
        String currMapping = Map[firstChar-'0'];
        
        for(int i=0;i<currMapping.length();i++) {
            op.append(currMapping.charAt(i));
            letterCombination(rstr, op, result);
            op.deleteCharAt(op.length()-1);
        }
    }
}
```
