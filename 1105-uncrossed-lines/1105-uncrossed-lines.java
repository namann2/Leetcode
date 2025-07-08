class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        // bottom up
        int[] prev = new int[m + 1];
        for(int index1 = 1; index1 < n+1; index1 ++) {
            int[] curr = new int[m + 1];
            for(int index2 = 1; index2 < m+1; index2 ++) {
                if(nums1[index1 - 1] == nums2[index2 - 1]) {
                    curr[index2] =  1 + prev[index2 - 1];
                } else {
                    curr[index2] = Math.max(prev[index2], curr[index2 - 1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}