/*
if the number has 25% probability and the other is 75%. 
This means that 3/4 times we get second number and 1/4 times we get first number.

So, assume we have a sampling to do. We have 1 apple and 3 bananas. We can say, that 3/4 times while doing sampling
we will get bananas and 1 times an apple.

I want to repeat the number as many times as the probability of the same.
For eg : To cover the above case we took [ Apple, Banana, Banana, Banana ] 


Consider a line that represents the range of freq of these probability
w = [1, 2, 3, 4]

    <-1-> <--  2 --> <----- 3 -----> <-------- 4 ------->
    -----|----------|---------------|--------------------|
  0      1          3               6                   10      this corresponds to the prefix sum
  
Now, if we pick a random number from the prefix sum and check which range it lies, we need to check where it lies.

*/
class Solution {
    
    int[]prefix;
    int sum = 0, n;
    public Solution(int[] w) {
        this.n = w.length;
        prefix = new int[n];
        prefix[0] = w[0];
        for(int i=1;i<n; i++)
            prefix[i] = prefix[i-1] + w[i];
        sum = prefix[n-1];
    }
    
    public int pickIndex() {
        int min = 0, max = sum;
        int rsum = (int)(Math.random() * (max - min) + min);
        int start = 0, end = n-1, ans = 0;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(rsum < prefix[mid]) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
