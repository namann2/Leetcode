```
class Solution {
public List<List<Integer>> combinationSum2(int[] can, int target) {
/*
TC : We have to calculate all combinations to find the potentials lists
nlogn + 2^n * time taken to copy the lists to final result (avg length of                         recursion  -> let k )
TC : 2^n * k
As we have non-distinct elements thus, it makes sense to sort the input
and avoid the program to go into the same recursion path.
*/
List<List<Integer>> result = new ArrayList();
Arrays.sort(can);
cs2(can, 0, can.length, target, new ArrayList<Integer>(), result);
return result;
}
private void cs2(int[] can, int index, int n,int target, ArrayList<Integer>temp, List<List<Integer>> result) {
// base logic
if(target==0) {
result.add(new ArrayList<Integer>(temp));