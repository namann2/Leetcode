class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        /*
        this is a dp problem
        dp state : dp[i][diff],for a diff what are the number of subsequences can be made
        ending at index i
        check pepcoding video : for understanding the logic
        */
        
        int n = nums.length;
        if(n < 3) 
            return 0;
        
        HashMap<Integer, Integer>[] A = new HashMap[n];
        for(int i = 0; i < n; i++)
            A[i] = new HashMap<>();
        
        int ans = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                long ldiff = 1l * nums[i] - 1l * nums[j];
                if(ldiff <= Integer.MIN_VALUE || ldiff >= Integer.MAX_VALUE)
                    continue;
                
                int diff = (int)ldiff;
                int endingAtJ = A[j].getOrDefault(diff, 0);
                
                ans += endingAtJ;
                A[i].put(diff, A[i].getOrDefault(diff, 0) + endingAtJ + 1);
            }
        }
        return ans;
    }
}