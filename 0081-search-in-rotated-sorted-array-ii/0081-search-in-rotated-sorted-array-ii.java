class Solution {
    public boolean search(int[] A, int k) {
        int start = 0, end = A.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(A[mid] == k) return true;
            else if(A[mid] == A[start] && A[mid] == A[end]) {
                start++;
                end--;
            } else if(A[start] <= A[mid]) {
                if(k >= A[start] && k <= A[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if(k >= A[mid+1] && k <= A[end]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return false;
    }
}