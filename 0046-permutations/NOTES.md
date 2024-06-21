```
class Solution {
public List<List<Integer>> permute(int[] nums) {
List<List<Integer>> result = new ArrayList();
if(nums == null || nums.length == 0) return result;
int[] boxes = new int[nums.length];
Arrays.fill(boxes, -11);
permutation(boxes, 0, nums, result);
return result;
}
private void permutation(int[] B, int idx, int[] A, List<List<Integer>> result) {
// base case
if(idx >= A.length) {
List<Integer> temp = new ArrayList();
for(int num : B) temp.add(num);
result.add(temp);
return;
}
// main logic
// point to note -> we iterate over boxes in permutation i.e. 0->box.length
for(int i=0;i<B.length;i++) {
if(B[i] == -11) {
B[i] = A[idx];
permutation(B, idx+1, A, result);