`Solution 2 : `
​
```
public class Solution extends Relation {
// Check Notes :
// Solution 2 : TC : O(n) and SC : O(1)
public int findCelebrity(int n) {
int candidate_cbc = 0; // a could-be-celebrity
for(int i=1;i<n;i++) {
if(!knows(candidate_cbc, i) && knows(i, candidate_cbc)) {
// pass
} else {
candidate_cbc = i;
} // if(knows(candidate_cbc, i) || !knows(i, candidate_cbc))
}
// check whether the could-be-celebrity is in actual a celebrity
for(int i=0;i<n;i++) {
if(i!=candidate_cbc && (!knows(i, candidate_cbc) || knows(candidate_cbc, i))) return -1;
}
return candidate_cbc;
}
}
```
​
`______________`