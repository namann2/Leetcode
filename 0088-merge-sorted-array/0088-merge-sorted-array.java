class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-1, q = n-1, t = n+m-1;
        while(p >=0 && q >= 0) {
            if(nums1[p] > nums2[q]) {
                nums1[t--] = nums1[p--];
            } else {
                nums1[t--] = nums2[q--];
            }
        }
        
        while(p >= 0)
            nums1[t--] = nums1[p--];
        while(q >= 0)
            nums1[t--] = nums2[q--];
    }
}