class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n : nums) s.add(n);
        int maxi = -1;
        for(int i : nums) {
            if(s.contains(-i)) maxi = Math.max(maxi, i);
        }
        return maxi;
    }
}