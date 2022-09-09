class Solution {
    public int[] searchRange(int[] A, int target) {
        int n = A.length;
        int[]res = {-1, -1};
        res[0] = bs(A, 0, n-1, target, true);
        res[1] = res[0] == -1 ? -1 : bs(A, 0, n-1, target, false);
        return res;
    }
    
    private int bs(int[] A, int start, int end, int target, boolean firstOccurence) {
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(A[mid] == target) {
                if(firstOccurence == true) end = mid - 1;
                else start = mid + 1;
                ans = mid;
            }
            else if(A[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return ans;
    }
}