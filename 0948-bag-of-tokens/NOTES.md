Story Points : 
- From the question, it was very clear that it was a greedy problem.
- We needed the smallest value to reduce our power so that we can make our `score=1`. Hence, `Sorting` is required.
- At a point, we only reduce our score in order to increase the power `iff`, we have an option in our array to increase the score afterwards else, we would be decreasing the score in vain.

With these three points, here is the code : 

```
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // greedy approach
        int n = tokens.length;
        if(tokens == null || n == 0) return 0;
        
        Arrays.sort(tokens);
        
        if(power < tokens[0]) return 0;
        
        int score = 0;
        int left = 0, right = n-1;
        
        while(left <= right) {
            if(power >= tokens[left]) {
                power -= tokens[left++];
                score++;
            }  
            else if(score >= 1 && left < right) { // only increase power or i.e. decrease score only if we have the chance to increase score afterwards. Thus, left < right or left != right
                power += tokens[right--];
                score--;
            } else break;
        }
        return score;
    }
}
```
