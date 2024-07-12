class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if(k == n) {
            return Arrays.stream(cardPoints).sum();
        }
        int sum = 0, end = 0, begin = 0, wsize = n - k, currSum = 0, minSum = Integer.MAX_VALUE;
        while(end < n) {
            sum += cardPoints[end];
            currSum += cardPoints[end];
            while(end-begin+1 > wsize) {
                currSum -= cardPoints[begin++];
            }
            if(end-begin+1 == wsize) {
                minSum = Math.min(minSum, currSum);
            }
            end++;
        }
        return sum - minSum;
    }
}