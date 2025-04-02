class Solution {

    private static final double EPS = 0.0000001d, REQUIRED = 24d;

    public boolean judgePoint24(int[] cards) {
        int n = cards.length;
        List<Double> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(1d * cards[i]);
        return settleGame(list);
    }

    private boolean settleGame(List<Double> list) {
        int n = list.size();
        // base case
        if(n == 1) {
            return Math.abs(list.get(0) - REQUIRED) <= EPS;
        }

        // main logic
        for(int i = 0; i < n; i++) {
            double first = list.get(i);
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                double second = list.get(j);
                List<Double> newList = new ArrayList<>();
                for(int k = 0; k < n; k++) {
                    if(k == i || k == j) continue;
                    newList.add(list.get(k));
                }
                List<Double> options = getOptions(first, second);
                for(double option : options) {
                    newList.add(option);
                    if(settleGame(newList))
                        return true;
                    newList.remove(newList.size()-1);
                }
            }
        }
        return false;
    }

    private List<Double> getOptions(double first, double second) {
        return List.of(
            first + second,
            first - second,
            first * second,
            first / second
        );
    }
}