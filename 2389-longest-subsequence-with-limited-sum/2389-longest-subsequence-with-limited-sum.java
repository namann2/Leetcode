class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        // in subsequence, order of elements matter, but for this question's use case
        // it is not required. It is actually an ask to sort the input
        int n = nums.length, m = queries.length;
        int[]ps = new int[n];
        Arrays.sort(nums);
        ps[0] = nums[0];
        for(int i=1;i<n;i++)
            ps[i] = ps[i-1] + nums[i];
        
        int[]ans = new int[m];
        for(int i=0;i<m;i++) {
            int index = binarySearch(ps, queries[i], n);
            ans[i] = index + 1;
        }
        return ans;
    }
    private int binarySearch(int[] nums, int val, int n) {
        int start = 0, end = n-1, ans = -1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] <= val) {
                ans = mid;
                start = mid + 1; 
            } else end = mid - 1;
        }
        return ans;
    }
}
