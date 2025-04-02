```
  3,3
   (
   2,3
1,3   2,2
((    ()
```


1. open == close ==> choose open ( choosing open is only valid )
2. open < close ( we can choose either of the two options ) <br>
   2.1 open > 0 ==> choose open <br>
   2.2 close > 0 ==> choose close
   
```
class Solution {
    /*
        Fairly straight-forward : 
        start with n = 3
        and dry run
        TC : O(2^n)
    */
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n,n,result,new StringBuilder());
        return result;
    }
    private void generateParenthesis(int open, int close, List<String> result,StringBuilder s) {
        if(open==0 && close==0) {
            result.add(s.toString());
            return;
        }
        if(open == close) {
            s.append('(');
            generateParenthesis(open-1, close, result, s);
            s.deleteCharAt(s.length()-1);
        }
        else {
            if(open>0) {
                s.append('(');
                generateParenthesis(open-1, close, result, s);
                s.deleteCharAt(s.length()-1);
            }
            if(close>0) {
                s.append(')');
                generateParenthesis(open, close-1, result, s);
                s.deleteCharAt(s.length()-1);
            }
        }
    }
}
```​
