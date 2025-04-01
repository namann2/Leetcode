class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        combination(1, 10, k, n, new ArrayList<>(), answer);
        return answer;
    }

    private void combination(int start, int n, int k, int target, List<Integer> temp, List<List<Integer>> answer) {
        if(target == 0 && k == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        if(start >= n || k < 0 || target < 0) return;

        temp.add(start);
        combination(start + 1, n, k - 1, target - start, temp, answer);
        temp.remove(temp.size()-1);

        combination(start + 1, n, k, target, temp, answer);
    }
}