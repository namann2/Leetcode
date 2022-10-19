Combination is subsets/subsequences.

# Time complexity : 

k * 2^target <br>

as we can use an element any number of times, thus 2^target
eg : [1], target = 10
we have to go on recursive depth equals to the target.

TC : O(2^target) * O(k) where k is the average length of recursive path <br>
SC : O(n) <br>

As we have disinct elements, we have a choice to either use <br>
for loop approach or pick-notPick approach <br>
        
One thing to consider as well, <br>
can we have a repeated output in case of combinations ? <br>
like, if we have 2 elements 3,5, we can only select them and <br>
not arrange them, because combination means only selection <br>
        
Thus, we are safe to use any of the approaches


# APPROACH 1 :  PICK - NOT PICK [ Subsequence / Subsets ]

```
 class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        combination(candidates, 0, candidates.length, new ArrayList<>(), target, answer);
        return answer;
    }
    private void combination(int[] candidates, int index, int n, List<Integer> temp, int target, List<List<Integer>> answer) {
        // base case
        if(target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        
        if(target < 0 || index >= n)
            return;
        
        // main logic
        temp.add(candidates[index]);
        combination(candidates, index, n, temp, target - candidates[index], answer);
        temp.remove(temp.size()-1);
        
        combination(candidates, index+1, n, temp, target, answer);
    }
}
```


APPROACH 2 : [ When we have a repeatition in input, this code is then more helpful -> Draw a recursive path and see ]

```
class Solution {
    
    public List<List<Integer>> combinationSum(int[] can, int target) {
        List<List<Integer>> result = new ArrayList<>();
        cs(can, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    private void cs(int[] can, int index, int target, ArrayList<Integer> temp, List<List<Integer>> result) {
        
        if(target==0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target<0) return;
        
        for(int i=index;i<can.length;i++) {
            temp.add(can[i]);
            cs(can, i, target-can[i], temp, result);
            temp.remove(temp.size()-1);
						// don't pick logic is handled by for loop iteration.
            // if in case, the option to use the current element is exhausted
            // we would go in backtracking and move ahead to another element
            // which is handled by the for loop
        }
    }
}
```
