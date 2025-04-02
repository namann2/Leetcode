class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> answer = new ArrayList<>();
        if(n > 1) {
            getFactors(2, n, new ArrayList<>(), answer);
        }
        return answer;
    }

    private void getFactors(int start, int n, List<Integer> temp, List<List<Integer>> answer) {
        // base case
        if(n == 1 && temp.size() > 1) { // factors are required hence, size of temp > 1
            answer.add(new ArrayList<>(temp));
            return;
        }
        // main logic
        for(int factor = start; factor <= n; factor++) {
            if(n % factor != 0) continue;
            temp.add(factor);
            getFactors(factor, n/factor, temp, answer);
            temp.remove(temp.size()-1);
        }
    }
}