class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        combinationsum(candidates, 0, candidates.length, target, new ArrayList<>(), answer);
        return answer;
    }
    
    private void combinationsum(int[] candidates, int index, int n, int target, List<Integer> temp,  List<List<Integer>> answer) {
        if(target < 0) return;
        if(target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = index; i < n && candidates[i] <= target; i++) {
            if(i > index && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            combinationsum(candidates, i+1, n, target - candidates[i], temp, answer);
            temp.remove(temp.size()-1);   
        }
    }
}