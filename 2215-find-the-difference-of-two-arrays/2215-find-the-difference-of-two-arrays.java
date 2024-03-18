class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.
            asList(
                    getElementsOnlyInFirstList(nums1, nums2),
                    getElementsOnlyInFirstList(nums2, nums1)
            );
    }
    private List<Integer> getElementsOnlyInFirstList(int[] nums1, int[] nums2) {
        Set<Integer> A = new HashSet<> (); 
        Set<Integer> B = new HashSet<> (); 
        
        for (int num : nums2) {
            B.add(num);
        }
        
        for (int num : nums1) {
            if (!B.contains(num)) A.add(num);
        }
        
        return new ArrayList<>(A);
    }
}