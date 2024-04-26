/*
​
0 : ["John","johnsmith@mail.com","john_newyork@mail.com"]
1 : ["John","johnsmith@mail.com","john00@mail.com"]
2 : ["Mary","mary@mail.com"]
3 : ["John","johnnybravo@mail.com"]
step1
johnsmith@mail.com : 0
john_newyork@mail.com : 0
john00@mail.com : 1
mary@mail.com : 2
johnnybravo@mail.com : 3
step 2:
0 - johnsmith@mail.com, john_newyork@mail.com, john00@mail.com
2 - mary@mail.com
3 - johnnybravo@mail.com
*/
​
```
class Solution {
public List<List<String>> accountsMerge(List<List<String>> accounts) {
/*