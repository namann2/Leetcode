class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for(int card : cards)
            list.add(1d * card);
        
        return judge(list, list.size());
    }
    
    private boolean judge(List<Double> cards, int n) {
        // base case
        if(cards.size() == 1) {
            return Math.abs(cards.get(0) - 24) <= 0.000000001;
        } 
        
        // n * (n^2 * )
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                // get all options from i and j
                List<Double> options = getOptions(cards.get(i), cards.get(j));
                List<Double> nextIteration = new ArrayList<>();
                for(int k = 0; k < n; k ++) {
                    if(k != i && k != j) {
                        nextIteration.add(cards.get(k));
                    }
                }
                
                for(double num : options) {
                    nextIteration.add(num);
                    if(judge(nextIteration, nextIteration.size())) return true;
                    nextIteration.remove(nextIteration.size()-1);
                }
            }
        }
        return false;
    }
    
    private List<Double> getOptions(double a, double b) {
        List<Double> options = new ArrayList<>();
        options.add(a + b);
        options.add(a - b);
        options.add(b - a);
        options.add(a * b);
        options.add(a / b);
        options.add(b / a);
        return options;
    }
}