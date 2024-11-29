class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> uniques = new HashSet<>();
        for(int num : nums) uniques.add(num);
        
        int uniqueLength = uniques.size();
        int[] unique = new int[uniqueLength];
        int idx = 0;
        for(int num : uniques)
            unique[idx++] = num;
        
        Arrays.sort(unique);
        
        // max - min = n - 1;
        // max = n + min - 1;
        int minOperations = Integer.MAX_VALUE;
        for(int i = 0; i < uniqueLength; i++) {
            int min = unique[i];
            int max = n + min - 1;
            int insertIndex = findNumberOfOperations(unique, max);
            int inRange = (insertIndex - i);
            int toChange = (n - inRange);
            // System.out.println(min+" :: "+max+" :: "+insertIndex + ":: "+inRange+" :: "+toChange);
            minOperations = Math.min(minOperations, toChange);
        }
        
        return minOperations;
    }
    
    private int findNumberOfOperations(int[] unique, int num) {
        // ....start...ans....end.......
        int n = unique.length;
        int start = 0, end = n-1;
        int ans = 0;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(unique[mid] <= num) {
                ans = mid + 1; // mid is still in range
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }
}