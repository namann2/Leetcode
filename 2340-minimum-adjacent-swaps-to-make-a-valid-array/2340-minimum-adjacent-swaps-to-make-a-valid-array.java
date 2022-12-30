class Solution {
    public int minimumSwaps(int[] nums) {
        if(nums == null || nums.length == 1)
            return 0;
        
        int n = nums.length;
        int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE;
        int si = 0, li = 0;
        
        for(int i=0;i<n;i++) {
            if(smallest > nums[i]) {
                si = i;
                smallest = nums[i];
            }
        }
        
        for(int i=n-1;i>=0;i--) {
            if(largest < nums[i]) {
                li = i;
                largest = nums[i];
            }
        }
        
        System.out.println(si +" :: "+li);
        int x = si + (n - 1) - li;
        // if in case, we have smallest element to the right of largest element
        // then, one swap will be made between the smallest and the largest element
        // hence, we need to reduce one swap
        // eg : 2 3 '5' 3 2 '1'
        return si > li ? x - 1 : x;
    }
}

/*
    Options : 
        greedy
        bfs
        dynamic programming
    
    greedy : 
    Greedily select elements to move such that we add minimum swaps
    
*/