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