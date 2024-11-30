```
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        HashSet<Integer> uniqueElements = new HashSet<>();
        for(int num : nums) 
            uniqueElements.add(num);
        
        int uniqueLength = uniqueElements.size();
        int[] uniques = new int[uniqueLength];
        int idx = 0;
        for(int number : uniqueElements) {
            uniques[idx++] = number;
        }
        
        Arrays.sort(uniques);
        
        int minNumber = n;
        for(int i = 0; i < uniqueLength; i++) {
            int min = uniques[i];
            int max = min + n - 1; // max = min + n - 1
            int index = findIndex(uniques, max, 0, uniqueLength - 1, n);
            int toChange = n - (index - i);
            minNumber = Math.min(minNumber, toChange);
        }
        return minNumber;
    }
    
    private int findIndex(int[] uniques, int target, int start, int end, int n) {
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            // 1 2 2 3
            // 2
            if(target >= uniques[mid]) {
                ans = mid + 1;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }
}
```
