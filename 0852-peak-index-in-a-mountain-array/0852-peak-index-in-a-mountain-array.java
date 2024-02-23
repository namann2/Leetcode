class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int start = 1, end = A.length-2;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(A[mid] > A[mid+1] && A[mid] > A[mid-1]) return mid;
            // means the mountain index is on right
            else if(A[mid] < A[mid+1]) start = mid + 1;
            else end = mid -1;
        }
        return -1;
    }
}