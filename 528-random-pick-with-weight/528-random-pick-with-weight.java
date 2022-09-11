/*
    if prob of picking an index i is w[i] / sum. We can say,
    sum = total outcomes
    
    eg : [1,2,3,4,3], sum = 13
    i.e. index 0 is picked 1/13 times 
         index 1 is picked 2/13 times etc (which means that out of 13 times, index 1 is repeated 2 times)
         [0,1,1,2,2,2,3,3,3,3,4,4,4] -> total indices = 13
         [0,1,2,3,4,5,6,7,8,9,10,11,12]
         
         pick a random number and return it.
         
         Above array can be written as :

         [1,3,6,10,13]
         [0,1,2,3,4]
         0 index range - [0, 1)
         1 index range - [1, 3) etc
*/
class Solution {

    int[]ps;
    public Solution(int[] w) {
        int n = w.length;
        ps = new int[n];
        ps[0] = w[0];
        for(int i=1;i<n;i++) 
            ps[i] = ps[i-1] + w[i];
    }
    
    public int pickIndex() {
        int random = (int)(Math.random() * ps[ps.length-1]); // check this corresponds to which index, find the range
        int ans = 0;
        int start = 0, end = ps.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(ps[mid] > random) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
}
