//TC: O(2^n) * O(n)
/* SC:
space complexity of recursive algorithm is proportinal to maximum depth of
recursion tree generated.
s[i]
/.      \
s[i]->LowerCase   s[i]->UpperCase
/.  \
Lower. Upper
TC : n* 2^n
SC : n (stack at any point in time)
Stack : f(s[i]) -> f(s[i]->lowercase()) -> f(s[i]->UpperCase())
*/