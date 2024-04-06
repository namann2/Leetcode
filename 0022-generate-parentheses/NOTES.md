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