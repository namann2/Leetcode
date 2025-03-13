class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = candidates.length;
        cs(candidates, 0, n, target, new ArrayList<>(), result);
        return result;
    }

    private void cs(int[] candidates, int index, int n, int target, List<Integer> temp, List<List<Integer>> result) {
        // base case
        if(target < 0 || index >= n) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // main logic
        for(int i = index; i < n; i++) {
            temp.add(candidates[i]);
            cs(candidates, i, n, target - candidates[i], temp, result);
            temp.remove(temp.size()-1);
        }
    }
}