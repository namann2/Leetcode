class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        int n = map.size();
        int[] unique = new int[n];
        int idx = 0;
        for(int num : map.keySet())
            unique[idx++] = num;
        
        quickSelect(unique, map, 0, n-1, n-k);
        
        int[] ans = new int[k];
        int l = k-1;
        while(l >= 0) {
            ans[l--] = unique[n-1];
            n--;
        }
        
        return ans;
    }
    
    private int quickSelect(int[] unique, Map<Integer, Integer> map, int left, int right, int k) {
        int pi = partition(unique, map, left, right);
        if(pi == k) return pi;
        else if(k > pi) return quickSelect(unique, map, pi + 1, right, k);
        return quickSelect(unique, map, left, pi - 1, k);
    }
    
    private int partition(int[] unique, Map<Integer, Integer> map, int left, int right) {
        int pivot = right;
        int i = left, j = left;
        
        while(i <= right) {
            if(map.get(unique[i]) <= map.get(unique[pivot])) {
                swap(unique, i, j);
                i++;
                j++;
            } else i++;
        }
        return j-1;
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}