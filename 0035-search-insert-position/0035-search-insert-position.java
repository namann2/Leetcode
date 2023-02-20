class Solution {
    public int searchInsert(int[] A, int T) {
        int n = A.length;
        int start = 0, end = n-1;
        while(start <= end) {
            int mid = (start+end)>>1;
            if(A[mid] == T)
                return mid;
            else if(A[mid] >= T) {
                end = mid-1;
            }
            else {
                start = mid + 1;
            }
        }
        return end+1;
    }
}