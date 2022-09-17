class Solution {
    public int minMoves(int[] nums) {
        /*
            suppose there are n elements in the array, the sum of original array
            is s0.
            Suppose minimum m moves are required to convert the number. So, after m 
            moves the number becomes something like eeee....n times 
            
            sum of new numbers will be n*e as there are n elements and each element
            is equal to `e`
            
            thus, we can say
            s0 + m*(n-1) = n * e -> eq1
            
            Also, minElement + m = e because the min element will remain min until it 
            reaches e because the other elements will also be incremented
            
            
            If we substitute, we will get
            
            s0 - min * n = m
        */
            
        int sum = 0, n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        
        return sum - min * n;
    }
}