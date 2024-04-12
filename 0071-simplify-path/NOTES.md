```
class Solution {
public String simplifyPath(String path) {
​
int n = path.length();
Deque<String> q = new ArrayDeque<>();
// iterate over string and add path to q
for(String in : path.split("/")) {
if(in.length()==0 || in.equals(".")) continue;
else if(in.equals("..")) {
if(!q.isEmpty()) q.removeLast();
}
else {
q.addLast(in);
}
}
// if the input case is : "/"
if(q.isEmpty())
return "/";
StringBuilder R = new StringBuilder();
while(!q.isEmpty()) {
R.append("/").append(q.removeFirst());
}
return R.toString();
}
}
```