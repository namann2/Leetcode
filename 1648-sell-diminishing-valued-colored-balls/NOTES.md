class Solution {
    public int maxProfit(int[] A, int orders) {
        int n = A.length;
        Arrays.sort(A);
        /*
        
            In the given array, there will be some balls that will not be picked !
            If we sort the input array, we can find the balls which actually needs
            to be picked.
            
            F F F F T T T T
            now, the only thing we need to see is, how many balls we need to pick
            
            Logic : 
            Part 1 : 
            Binary Search on the minimum value that needs to be picked
            F F F F "T" T T T
                     |
                    this
                    
            Part 2 : 
            Pick balls
            
            eg : [1,3,6,7,9], k=4
               : output => 31
        */
        int start = 0, end = Arrays.stream(A).max().getAsInt();
        int ans = 0;
        long k = 1L * orders;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            // if < k, we have picked a bigger ball value hence, look for small
            // number of orders if we pick all balls with value >= mid
            long cnt = numberOfOrders(A, mid);
            if(cnt < k) {
                end = mid - 1;
            }
            else {
                ans = mid;
                start = mid + 1;
            }
        }
        
        long profit = 0;
        int mod = (int)1e9+7;
        
        /*
            we are not necessarily buying all those balls with "ans" value,
            but it is guaranteed that we need to buy all the balls with value greater than 
            ans value T(hence we set ans++). 

            After that, we ran out of the balls with value greater than ans value, 
            now, we can only add balls with ans value for (orders we left) times.
        */
        
        ans ++;
        
        for(int i=n-1;i>=0 && k > 0;i--) {
            if(A[i] >= ans) 
            {   // (7 + 9) * ( 9 - 7 + 1) / 2
                // 16 * 3 / 2 -> 24
                // 9 + 8 + 7
                profit += (1l * ans + A[i]) * (A[i] - ans + 1) / 2;
                profit %= mod;
                k -= (A[i] - ans + 1);
            }
        }
        
        ans--;
        
        while(k-- > 0) {
            profit += ans;
            profit %= mod;
        }
        
        return (int)(profit % mod);
    }
    
    private long numberOfOrders(int[]A, int limit) {
        long cnt = 0;
        int n = A.length;
        for(int i=n-1;i>=0;i--) {
            if(A[i] >= limit)
                cnt += A[i] - limit + 1; 
            else break;
        }
        return cnt;
    }
}
