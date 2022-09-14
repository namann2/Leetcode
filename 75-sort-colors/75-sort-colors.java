class Solution {
    public void sortColors(int[] A) {
        // inplace i.e 3 options - replacements, swaps, no extra space(i.e variables)
        int n = A.length;
        int left = 0, right = n-1, itr = 0;
        while(itr<=right) {
            if(A[itr] == 0) {
                swap(A, itr, left);
                left++;
                itr++;
            }
            else if(A[itr] == 1) itr++;
            else if(A[itr] == 2) {
                swap(A, itr, right);
                right--;
            }
        }
    }
    private void swap(int[]A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
